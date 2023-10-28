import os
from .support import *
from .forms import *

from datetime import datetime
from application.database import db
from flask import flash, render_template, request, redirect, session
from flask import current_app as app
from application.models import User, Post, Follows, PostLike, Comments
from flask_login import current_user, login_user, logout_user, login_required
from werkzeug.urls import url_parse

###################################LOGIN############################################
@app.route('/login', methods=['GET', 'POST'])
def login():
    global next_page
    next_page = request.args.get('next')
    if not next_page or url_parse(next_page).netloc != '':
        next_page = '/'

    if current_user.is_authenticated:
        return redirect('/')
    
    form = LoginForm()
    if form.validate_on_submit():
        if request.form.get("submit"):
            user = User.query.filter_by(name=form.username.data).first()
            if user is None or not user.check_password(form.password.data):
                print('Invalid username or password')
                return render_template('error.html', current_user=session, message=messages["LOGIN_FAILURE"])
                # return redirect('/login')
            login_user(user, remember=form.remember_me.data)

            session["id"] = current_user.get_id()
            session["name"] = current_user.get_name()

            # redirect to appropriate page, if it came here due to "login_required"
            next_page = request.form.get('next_page')
            print(next_page)
            if not next_page or url_parse(next_page).netloc != '':
                next_page = '/'
            return redirect(next_page)
        elif request.form.get("signup"):
            return redirect("user/create")
    return render_template('login.html', next_page=next_page, title='Sign In', form=form)

@app.route('/logout', methods=['GET', 'POST'])
def logout():
    logout_user()
    session.clear()
    next_user = ""
    return redirect('login')

###################################POSTS############################################
@app.route("/post/create/", methods=["GET", "POST"])
@login_required
def post_create():
    form = PostCreateForm()
    if form.validate_on_submit():
        user_id = session['id']
        title = request.form['title']
        description = request.form['description']
        timestamp = datetime.now()
        image_url = image_upload('post') or 'default.jpg'

        post = Post(user_id, title, description, image_url, timestamp)
        
        result = add_record(post)
        if isinstance(result, str):
            return render_template('error.html', current_user=session, message=messages["DB_OPS_FAILURE"])
        return render_template('post_create.html', current_user=session, flag=True, form=form), 200
    return render_template('post_create.html', current_user=session, flag=False, form=form), 200

@app.route("/post/edit/<post_id>", methods=["GET", "POST"])
@login_required
def post_edit(post_id):
    post = get_post(post_id)
    post_user = get_user(post.user_id)
    post_like_count = get_postlikes(session['id'], post_id)

    # Process comments for this post.
    comments = get_comments(post_id)
    comments_data = []
    for each in comments:
        comment_user = get_user(each.user_id)
        comments_data.append((comment_user.user_id, comment_user.name, each.comment.split('\r\n')))

    # is post by current user?
    can_edit = post.user_id == session['id']

    image_url = post.image_url
    if image_url != '':
        image_full_url = os.path.join("..\..", app.config['UPLOAD_FOLDER'], image_url)
    else:
        image_full_url = ''
    
    post_date = post.timestamp.split()[0]

    if request.method == "GET":
        if not can_edit:
            db.session.autoflush = False
            post.description = post.description.split('\r\n') # handle newlines in the description.
        modified_post_data = (post.post_id, post_user.user_id, post_user.name, post.title, post.description, image_url, image_full_url, post_date, post_like_count)
        return render_template('post_edit.html', current_user=session, post=modified_post_data, comments=comments_data, can_edit=can_edit, post_flag=False, comment_flag=False), 200
    elif request.method == "POST":
        if request.form.get("add_comment"):
            comment = request.form['comment']
            comment_object = Comments(session['id'], post_id, comment)
            add_record(comment_object)
            return redirect(f'/post/edit/{post_id}'), 301
        else:
            if request.form.get("Update"):
                try:
                    post.title = request.form['title']
                    post.description = request.form['description']
                    post.image_url = image_upload('post') or post.image_url
                    post.image_full_url = os.path.join("..\..", app.config['UPLOAD_FOLDER'], post.image_url)
                    db.session.commit()
                except:
                    return render_template('error.html', current_user=session, message=messages["DB_OPS_FAILURE"])

                modified_post_data = (post.post_id, post_user.user_id, post_user.name, post.title, post.description, post.image_url, post.image_full_url, post_date, post_like_count)
                return render_template('post_edit.html', current_user=session, post=modified_post_data, comments=comments_data, can_edit=can_edit, post_flag=True, comment_flag=False), 200
            elif request.form.get("Delete"):
                if not delete_post(post_id):
                    return render_template('error.html', current_user=session, message=messages["DB_OPS_FAILURE"])
                    
                return redirect(f"/profile/{session['id']}"), 301

###################################USERS############################################
@app.route("/user/create", methods=["GET", "POST"])
@app.route("/signup", methods=["GET", "POST"])
def user_create():
    form = UserCreateForm()
    if form.validate_on_submit():
        name = request.form['username']
        pp_url = image_upload('user')
        if not pp_url:
            return render_template('error.html', current_user=session, message=messages["NO_IMAGE"])

        user = User(pp_url, name)
        user.set_password(request.form['password'])

        result = add_record(user)
        if isinstance(result, str) and "UNIQUE constraint failed" in result:
            return render_template('error.html', current_user=session, message=messages["USER_ALREADY_EXISTS"])
        # redirect("user/create"), 301
        return render_template('user_create.html', current_user=session, flag=True, form=form), 200
        # return render_template('user_create.html', current_user=session, flag=True, form=form), 200
    
    return render_template('user_create.html', current_user=session, flag=False, form=form), 200

@app.route("/user/edit/<user_id>", methods=["GET", "POST"])
@login_required
def user_edit(user_id):
    # Profile picture cannot be edited.
    user = get_user(user_id)
    user.pp_full_url = os.path.join("..\..", app.config['PP_FOLDER'], user.pp_url)

    form = UserEditForm()
    if form.validate_on_submit():
        if request.form.get("Update"):
            try:
                user.name = request.form['username']
                user.set_password(request.form['password'])
                db.session.commit()
            except:
                return render_template('error.html', current_user=session, message=messages["DB_OPS_FAILURE"])
            return render_template('user_edit.html', current_user=session, user=user, flag=True, form=form), 200
        elif request.form.get("Delete"):
            if not delete_user(user_id):
                return render_template('error.html', current_user=session, message=messages["DB_OPS_FAILURE"])
            return redirect('/'), 301
    return render_template('user_edit.html', current_user=session, user=user, flag=False, form=form), 200

###################################PROFILE############################################
@app.route("/profile/<user_id>", methods=["GET", "POST"])
@login_required
def profile(user_id):
    user = get_user(user_id)
    posts = get_post_by_user(user_id, count=0)
    num_follows = get_follows(user_id)
    num_followed_by = get_followed_by(user_id)

    user_data = (user_id, user.name, num_follows, num_followed_by, len(posts))
    
    pp_url = os.path.join("..", app.config['PP_FOLDER'], user.pp_url)

    can_add_post = session['id'] == int(user_id)

    if request.method == "GET":
        if len(posts) > 0:
            posts_with_image_url = posts.copy()
            for post in posts_with_image_url:
                post.description = '. '.join(post.description.split('.')[:3]) # First 3 lines
                if post.image_url != '':
                    post.image_url = os.path.join("..", app.config['UPLOAD_FOLDER'], post.image_url)
            return render_template('profile.html', current_user=session, user=user_data, pp_url=pp_url, posts=posts_with_image_url, can_add_post=can_add_post, flag=True), 200
        else:
            return render_template('profile.html', current_user=session, user=user_data, pp_url=pp_url, posts=[], can_add_post=can_add_post, flag=False), 200
    elif request.method == 'POST':
        return redirect('/post/create'), 301

###################################FEED############################################
@app.route("/", methods=["GET"])
@app.route("/feed", methods=["GET"])
@login_required
def feed():
    # Get all users current_user follows
    users = get_follows(session['id'], count=0)
    users_data = [each.follow_user_id for each in users]

    # Get posts of all above users.
    posts = db.session.query(Post).order_by(Post.timestamp.desc()).filter(Post.user_id.in_(users_data)).all()
    posts_data = []
    for post in posts:
        post.description = '. '.join(post.description.split('.')[:3]) # First 3 lines
        post_date = post.timestamp.split()[0]
        posts_data.append((post.user_id, post.post_id, post.title, post.description, post_date))

    modified_posts_data = []
    for post_data in posts_data:
        user_data = get_user(post_data[0])
        modified_posts_data.append((user_data.user_id, user_data.name, post_data[1], post_data[2], post_data[3], post_data[4]))

    return render_template('feed.html', current_user=session, posts=modified_posts_data)
###################################FOLLOW############################################
@app.route("/search_users/<term>", methods=["GET", "POST"])
@login_required
def search_users(term):
    print(session)
    if term == "all":
        all_users = User.query.all()
        all_users_data = [each.user_id for each in all_users]
        follows = get_follows(session['id'], count=0)
        follows_data = [each.follow_user_id for each in follows]
    else:
        searchterm = f"%{term}%"
        all_users = User.query.filter(User.name.like(searchterm)).all()
        all_users_data = [each.user_id for each in all_users]
        follows = get_follows(session['id'], count=0)
        follows_data = [each.follow_user_id for each in follows]
        follows_data = set(all_users_data).intersection(set(follows_data))

     # current_user_id shouldn't be listed.
    try:
        all_users_data.remove(session['id'])
    except:
        pass

    not_follows_data = set(all_users_data) - set(follows_data)

    if request.method == "GET":
        final_data = {0: {}, 1: {}}
        for each in not_follows_data:
            final_data[0][each] = get_user(each).name
        
        for each in follows_data:
            final_data[1][each] = get_user(each).name

        return render_template('search_users.html', current_user=session, term=term, final_data=final_data), 200
    elif request.method == "POST":
        if request.form.get("Search"):
            # "/search_users/all" lists all users in the system
            term = request.form['search'] or "all"
            searchterm = f"%{term}%"
            return redirect(f"/search_users/{term}")
        elif request.form.get("Update"):
            records = []
            for user in all_users_data:
                if request.form.get(str(user)) is not None:
                    records.append(Follows(session['id'], user))

            try:
                delete_follows(session['id'], all_users_data)
                db.session.add_all(records)
                db.session.commit()
            except:
                return render_template('error.html', current_user=session)
            
            return redirect(f"/search_users/{term}")

##################################LIKE-UNLIKE POSTS########################################
@app.route("/post/<post_id>/like", methods=["GET"])
@login_required
def postlike(post_id):
    try:
        like = request.args['like']
        if int(like):
            post_like = PostLike(session['id'], post_id)
            db.session.add(post_like)
        else:
            post_like = get_postlikes(session['id'], post_id, count=1)
            db.session.delete(post_like)
        db.session.commit()
    except:
        pass

    return redirect(f'/post/edit/{post_id}'), 301
