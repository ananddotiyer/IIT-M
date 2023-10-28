from workers import celery, ContextTask
from models import *
from database import db

from flask import Flask, request, send_from_directory
from flask_restful import Resource, Api
from flask_jwt_extended import JWTManager
from flask_cors import CORS

# from flask_sqlalchemy import SQLAlchemy
# from flask_uploads import UploadSet, configure_uploads, IMAGES

# import celery

app = Flask(__name__)

app.config["SQLALCHEMY_DATABASE_URI"] = 'sqlite:///database.sqlite3'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
app.config.update(CELERY_CONFIG={
    'broker_url': 'redis://localhost:6379/1',
    'result_backend': 'redis://localhost:6379/1',
    'timezone': 'Asia/Kolkata'
})

# app.config['UPLOADED_IMAGES_DEST'] = ""
# images = UploadSet('images', IMAGES)
# configure_uploads(app, images)

app.app_context().push()
db.init_app(app)

# Create 'admin' user, if it's a fresh database
if User.query.filter_by(name='admin').first() is None:
    db.session.add(User('admin', 'admin@ticketshow.com','pwd', True))
    db.session.commit()

api = Api(app)
app.app_context().push()

# Celery config
celery.conf.update(
    broker_url = "redis://localhost:6379/1",
    result_backend = "redis://localhost:6379/2",
    timezone='Asia/Kolkata'
)
celery.Task = ContextTask
app.app_context().push()

from controller_celery import *
from api import * # Order important

CORS(app)
jwt = JWTManager(app)
app.app_context().push()


api.add_resource(LoginAPI, "/api/login/")
api.add_resource(SignupAPI, "/api/signup/")

api.add_resource(DashboardAPI, "/api/dashboard/")
api.add_resource(TheatreEditAPI, "/api/theatre/<int:id>/get/",
                 "/api/theatre/<int:id>/edit/")
api.add_resource(TheatresAPI, "/api/theatre/create/",
                 "/api/theatre/<int:t_id>/delete/")
api.add_resource(TheatreSearchAPI, "/api/theatres/search/")

api.add_resource(ShowEditAPI, "/api/show/<int:id>/get/",
                 "/api/show/<int:id>/edit/")
api.add_resource(ShowsAPI, "/api/show/create/",
                 "/api/show/<int:s_id>/delete/")
api.add_resource(ShowSearchAPI, "/api/shows/search/")

api.add_resource(BookShowAPI, "/api/show/book/")

api.add_resource(ShowDateAPI, "/api/showdate/")

api.add_resource(RatingAPI, "/api/rating/")

@app.route('/upload/image', methods=['POST'])
def upload_image():
    print(request.files)
    if 'image' not in request.files:
        return jsonify({'error': 'No image file provided'}), 400

    image = request.files['image']

    if image.filename == '':
        return jsonify({'error': 'No selected file'}), 400

    image_url = f'uploads/{image.filename}'
    image.save(image_url)

    return jsonify({'imageUrl': image_url}), 200

@app.route('/uploads/<path:filename>')
def serve_uploaded_file(filename):
    return send_from_directory('uploads', filename)

if __name__ == '__main__':
    app.secret_key = 'super secret key'
    app.run(debug=True)
