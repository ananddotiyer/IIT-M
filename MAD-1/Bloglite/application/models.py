from .database import db
from flask_login import UserMixin
from main import login
from werkzeug.security import generate_password_hash, check_password_hash

@login.user_loader
def load_user(id):
    return User.query.get(int(id))

class User(UserMixin, db.Model):
    __tablename__ = 'user'
    user_id = db.Column(db.Integer, autoincrement=True, primary_key=True)
    pp_url = db.Column(db.String, nullable=False)
    name = db.Column(db.String, nullable=False)
    password = db.Column(db.String, nullable=True)

    def get_id(self):
        return (self.user_id)

    def get_name(self):
        return (self.name)

    # password_hash will set later
    def __init__(self, pp_url, name):
        self.pp_url = pp_url
        self.name = name

    def set_password(self, password):
        self.password = generate_password_hash(password)

    def check_password(self, password):
        return check_password_hash(self.password, password)

class Post(db.Model):
    __tablename__ = 'post'
    post_id = db.Column(db.Integer, autoincrement=True, primary_key=True)
    user_id = db.Column(db.Integer, db.ForeignKey('user.user_id'), nullable=False)
    title = db.Column(db.String)
    description = db.Column(db.String)
    image_url = db.Column(db.String)
    timestamp = db.Column(db.String)

    def __init__(self, user_id, title, description, image_url, timestamp):
        self.user_id = user_id
        self.title = title
        self.description = description
        self.image_url = image_url
        self.timestamp = timestamp

class Follows(db.Model):
    __tablename__ = 'follows'
    user_id = db.Column(db.Integer, db.ForeignKey('user.user_id'), primary_key=True)
    follow_user_id = db.Column(db.Integer, db.ForeignKey('user.user_id'), primary_key=True)

    def __init__(self, user_id, follow_user_id):
        self.user_id = user_id
        self.follow_user_id = follow_user_id

class PostLike(db.Model):
    __tablename__ = 'post_like'
    user_id = db.Column(db.Integer, db.ForeignKey('user.user_id'), primary_key=True)
    post_id = db.Column(db.Integer, db.ForeignKey('post.post_id'), primary_key=True)

    def __init__(self, user_id, post_id):
        self.user_id = user_id
        self.post_id = post_id

class Comments(db.Model):
    __tablename__ = 'post_comment'
    comment_id = db.Column(db.Integer, primary_key=True)
    user_id = db.Column(db.Integer, db.ForeignKey('user.user_id'))
    post_id = db.Column(db.Integer, db.ForeignKey('post.post_id'))
    comment = db.Column(db.String)

    def __init__(self, user_id, post_id, comment):
        self.user_id = user_id
        self.post_id = post_id
        self.comment = comment