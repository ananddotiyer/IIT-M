from . import support
from flask_restful import Resource, fields, marshal_with, reqparse
from application.database import db
# from application.models import User
from application.validation import DatabaseError, ValidationError, NotFoundError
from sqlalchemy.engine.row import Row
from datetime import datetime
###################################USERS############################################
user_fields = {
    "user_id": fields.Integer,
    "pp_url": fields.String,
    "name": fields.String,
    "password": fields.String
}

create_user_parser = reqparse.RequestParser()
create_user_parser.add_argument('pp_url')
create_user_parser.add_argument('name')
create_user_parser.add_argument('password')

class UserAPI(Resource):
    @marshal_with(user_fields)
    def get(self, user_id):
        user = support.get_user(user_id)
        
        if user:
            return user, 200
        else:
            raise NotFoundError(status_code=404, error_code=404, error_message="Unable to find user with specified ID")

    def delete(self, user_id):
        from .support import delete_user
        if not delete_user(user_id):
            raise DatabaseError(status_code=1004, error_code='BE1004')

    @marshal_with(user_fields)
    def put(self, user_id):
        from .support import api_image_upload
        args = create_user_parser.parse_args()
        pp_url = args.get('pp_url')
        pp_url = api_image_upload("user", pp_url) or "default.jpg"
        name = args.get('name')
        password = args.get('password')

        if name is None or pp_url is None or password is None:
            raise ValidationError(status_code=1000, error_code='BE1000', error_message='No inputs can be None.')

        user = support.get_user(user_id)
        try:
            user.name = name
            user.set_password(password)

            user.pp_url = pp_url
            db.session.commit()
        except Exception as e:
            raise DatabaseError(status_code=1004, error_code='BE1004', error_message=str(e))

        user = support.get_user(user_id)
        return user, 200

    @marshal_with(user_fields)
    def post(self):
        args = create_user_parser.parse_args()
        pp_url = args.get('pp_url')
        pp_url = support.api_image_upload("user", pp_url) or "default.jpg"
        name = args.get('name')
        password = args.get('password')

        if name is None or password is None:
            raise ValidationError(status_code=1000, error_code='BE1000', error_message='No inputs can be None.')

        new_user = support.User(pp_url=pp_url, name=name)
        new_user.set_password(password)
        try:
            db.session.add(new_user)
            db.session.commit()
        except Exception as e:
            raise DatabaseError(status_code=1004, error_code='BE1004', error_message=str(e))

        new_user = db.session.query(support.User).filter_by(name=name).first()
        return new_user, 201

###################################POSTS############################################
post_fields = {
    "post_id": fields.Integer,
    "user_id": fields.Integer,
    "title": fields.String,
    "description": fields.String,
    "image_url": fields.String,
    "timestamp": fields.String
}

create_post_parser = reqparse.RequestParser()
create_post_parser.add_argument('user_id')
create_post_parser.add_argument('title')
create_post_parser.add_argument('description')
create_post_parser.add_argument('image_url')

class PostAPI(Resource):
    @marshal_with(post_fields)
    def get(self, post_id):
        post = support.get_post(post_id)
        
        if post:
            return post, 200
        else:
            raise NotFoundError(status_code=404, error_code=404, error_message="Unable to find post with specified ID")

    def delete(self, post_id):
        if not support.delete_post(post_id):
            raise DatabaseError(status_code=1004, error_code='BE1004')

    @marshal_with(post_fields)
    def put(self, post_id):
        from .support import api_image_upload
        args = create_post_parser.parse_args()
        title = args.get('title')
        description = args.get('description')
        image_url = args.get('image_url')
        image_url = api_image_upload("post", image_url) or "default.jpg"

        if title is None:
            raise ValidationError(status_code=1000, error_code='BE1000', error_message='No inputs can be None.')

        post = support.get_post(post_id)
        try:
            post.title = title
            post.description = description
            post.image_url = image_url
            db.session.commit()
        except Exception as e:
            raise DatabaseError(status_code=1004, error_code='BE1004', error_message=str(e))

        return post, 200

    @marshal_with(post_fields)
    def post(self, user_id):
        print(user_id)
        args = create_post_parser.parse_args()
        title = args.get('title')
        description = args.get('description')
        image_url = args.get('image_url')
        image_url = support.api_image_upload("post", image_url) or "default.jpg"

        if title is None:
            raise ValidationError(status_code=1000, error_code='BE1000', error_message='No inputs can be None.')

        new_post = support.Post(user_id=user_id, title=title, description=description, image_url=image_url, timestamp=datetime.now())
        try:
            db.session.add(new_post)
            db.session.commit()
        except Exception as e:
            raise DatabaseError(status_code=1004, error_code='BE1004', error_message=str(e))

        new_post = support.get_post(new_post.post_id)
        return new_post

##################################FEED############################################
create_feed_parser = reqparse.RequestParser()
create_feed_parser.add_argument('user_id')

class FeedAPI(Resource):
    def get(self, user_id):
        # Get all users followed by user_id
        users = support.get_follows(user_id, count=0)
        users_data = [each.follow_user_id for each in users]

        # Get posts of all of the above users.
        posts = db.session.query(support.Post).order_by(support.Post.timestamp.desc()).filter(support.Post.user_id.in_(users_data)).all()
        posts_data = []
        for post in posts:
            post.description = '. '.join(post.description.split('.')[:3]) # First 3 lines
            post_date = post.timestamp.split()[0]
            posts_data.append((post.user_id, post.post_id, post.title, post.description, post_date))

        modified_posts_data = []
        for post_data in posts_data:
            user_data = support.get_user(post_data[0])
            modified_posts_data.append({
                "user_id": user_data.user_id, 
                "name": user_data.name, 
                "post_id": post_data[1], 
                "title": post_data[2], 
                "description": post_data[3], 
                "post_date":post_data[4]
                })

        return {"feed": modified_posts_data}