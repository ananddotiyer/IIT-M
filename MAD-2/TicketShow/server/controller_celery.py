import csv
import os

from tasks import *
from models import Theatre
from celery.result import AsyncResult
from workers import celery

from flask import current_app as app, jsonify
from flask_jwt_extended import jwt_required, get_jwt_identity

@app.route("/export/<t_id>/")
@jwt_required()
def export(t_id):
    theatres = Theatre.query
    task = export_theatre_details.delay(t_id)

    task_id = task.id
    return jsonify({'taskId': task_id})

@app.route('/task_status/<task_id>/<t_id>/', methods=['GET'])
def task_status(task_id, t_id):
    theatre = Theatre.query.filter_by(t_id=t_id).first()
    t_name = f"{theatre.name} ({theatre.place})" 

    task = AsyncResult(task_id, app=celery)
    status = task.status
    if status == 'SUCCESS':
        result = task.result['export_details']

        file_path = f'exports/{t_name}.csv'
        with open(file_path, 'w', newline='') as csvfile:
            fieldnames = ["s_id", "name", "rating", "start", "tag1", "tag2", "tag3"]
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
            csvfile.write("Following shows are(were) played in this theatre:\n\n")
            writer.writeheader()
            writer.writerows(result['shows'])

        with open(file_path, 'a', newline='') as csvfile:
            fieldnames = ["s_id", "user", "date", "seats", "cost"]
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
            csvfile.write("\nFollowing bookings were made to the shows in this theatre:\n\n")
            writer.writeheader()
            writer.writerows(result['bookings'])

        with open(file_path, 'a', newline='') as csvfile:
            fieldnames = ["s_id", "user", "date", "rating"]
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
            csvfile.write("\nFollowing user ratings were made to the shows in this theatre:\n\n")
            writer.writeheader()
            writer.writerows(result['ratings'])
    else:
        result = None
    return jsonify({'status': status, 'result': result})