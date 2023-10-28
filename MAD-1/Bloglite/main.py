import os
from flask import Flask
from flask_restful import Resource, Api
from application.config import LocalDevelopmentConfig
from application.database import db
from flask_login import LoginManager
from datetime import timedelta

app = None
api = None

def create_app():
    app = Flask(__name__, template_folder='templates')
    if os.getenv("ENV", "development") == "production":
        raise Exception("Currently no production config is setup")
    else:
        print("Starting Local Development")
        app.config.from_object(LocalDevelopmentConfig)

    db.init_app(app)
    api = Api(app)
    app.app_context().push()
    return app, api

app, api = create_app()
app.secret_key = "my_secret"
app.permanent_session_lifetime = timedelta(minutes=5)

login = LoginManager(app)
login.login_view = 'login'

# CAUTION:
# If you move the location of the following imports, 
# # you will end up with app_context error.
from application.controllers import *
from application.api import UserAPI, PostAPI, FeedAPI

# Users
api.add_resource(UserAPI, '/api/user/<int:user_id>',endpoint='get/user')
api.add_resource(UserAPI, '/api/user/<int:user_id>',endpoint='delete/user')
api.add_resource(UserAPI, '/api/user/<int:user_id>',endpoint='put/user')
api.add_resource(UserAPI, '/api/user',endpoint='post/user')

# Posts
api.add_resource(PostAPI, '/api/post/<int:post_id>',endpoint='get/post')
api.add_resource(PostAPI, '/api/post/<int:post_id>',endpoint='delete/post')
api.add_resource(PostAPI, '/api/post/<int:post_id>',endpoint='put/post')
api.add_resource(PostAPI, '/api/post/create/<int:user_id>', endpoint='post/user_id')

# Feed
api.add_resource(FeedAPI, '/api/feed/<int:user_id>',endpoint='get/feed')

if __name__ == "__main__":
    app.run(debug=True)