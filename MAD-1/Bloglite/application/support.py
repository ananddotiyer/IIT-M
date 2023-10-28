import os
import shutil
from flask import current_app as app
from werkzeug.utils import secure_filename
from application.database import db
from flask import Flask, render_template, request, redirect
from application.models import User, Post, Follows, PostLike, Comments

messages = {
    "DB_OPS_FAILURE": "Failure during database operation.",
    "NO_IMAGE": "Failed to upload image.",
    "LOGIN_FAILURE": "Login failed.  Check if the user/password combination is valid and try again!",
    "USER_ALREADY_EXISTS": "User already exists.  Please use a different name to signup."
}

ALLOWED_EXTENSIONS = ['png', 'jpg', 'jpeg']

next_page = ""  # Global variable to use with login

def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

def api_image_upload(image_type, pp_url):
    try:
        if image_type == "post":
            folder = "uploads"
        elif image_type == "user":
            folder = "pp"

        if pp_url and allowed_file(pp_url):
            img_path = os.path.join(app.static_folder, folder, secure_filename(os.path.basename(pp_url)))
            shutil.copyfile(pp_url, img_path)
            return os.path.basename(pp_url)
        else:
            return False
    except:
        return False

def image_upload(image_type):
    if image_type == "post":
        root = app.config['UPLOAD_FOLDER']
    elif image_type == "user":
        root = app.config['PP_FOLDER']
    try:
        if len(request.files) == 0:
            return False
        f = request.files['file']
        if f and allowed_file(f.filename):
            img_path = os.path.join(root, secure_filename(f.filename))
            f.save(img_path)
            return os.path.basename(img_path)
        else:
            return False
    except:
        return False

def add_record(record):
    try:
        db.session.add(record)
        db.session.commit()
        return True
    except Exception as e:
        return str(e)

def get_user(by, count=1):
    if count == 1:
        return User.query.filter_by(user_id=by).first()
    elif count == 0:
        return User.query.filter_by(user_id=by).all()
    elif count == 'count':
        return User.query.filter_by(user_id=by).count()

def get_post(by, count=1):
    if count == 1:
        return Post.query.filter_by(post_id=by).first()
    elif count == 0:
        return Post.query.filter_by(post_id=by).all()
    elif count == 'count':
        return Post.query.filter_by(post_id=by).count()

def get_post_by_user(by, count=1):
    if count == 1:
        return Post.query.filter_by(user_id=by).first()
    elif count == 0:
        return Post.query.filter_by(user_id=by).all()
    elif count == 'count':
        return Post.query.filter_by(user_id=by).count()

def get_postlikes(by_1, by_2, count='count'):
    if count == 1:
        return PostLike.query.filter_by(user_id=by_1, post_id=by_2).first()
    elif count == 0:
        return PostLike.query.filter_by(user_id=by_1, post_id=by_2).all()
    elif count == 'count':
        return PostLike.query.filter_by(user_id=by_1, post_id=by_2).count()

def get_comments(by, count=0):
    if count == 1:
        return Comments.query.filter_by(post_id=by).first()
    elif count == 0:
        return Comments.query.filter_by(post_id=by).all()
    elif count == 'count':
        return Comments.query.filter_by(post_id=by).count()

def get_follows(by, count='count'):
    if count == 1:
        return Follows.query.filter_by(user_id=by).first()
    elif count == 0:
        return Follows.query.filter_by(user_id=by).all()
    elif count == 'count':
        return Follows.query.filter_by(user_id=by).count()

def get_followed_by(by, count='count'):
    if count == 1:
        return Follows.query.filter_by(follow_user_id=by).first()
    elif count == 0:
        return Follows.query.filter_by(follow_user_id=by).all()
    elif count == 'count':
        return Follows.query.filter_by(follow_user_id=by).count()

def delete_post(by):
    try:
        Post.query.filter_by(post_id=by).delete()
        db.session.commit()
        return True
    except:
        return False

def delete_user(by):
    try:
        User.query.filter_by(user_id=by).delete()
        db.session.commit()
        return True
    except:
        return False

def delete_follows(by_1, by_2):
    try:
        for each in by_2:
            Follows.query.filter_by(user_id=by_1, follow_user_id=each).delete()
        db.session.commit()
        return True
    except:
        return False