import json
from werkzeug.exceptions import HTTPException
from flask import make_response

class NotFoundError(HTTPException):
    def __init__(self, status_code, error_code, error_message):
        response = json.dumps({"error_code": error_code, "error_message": error_message})
        self.response = make_response(response, status_code)

class DatabaseError(HTTPException):
    def __init__(self, status_code, error_code, error_message="Database operation failure"):
        response = json.dumps({"error_code": error_code, "error_message": error_message})
        self.response = make_response(response, status_code)

class ValidationError(HTTPException):
    def __init__(self, status_code, error_code, error_message):
        response = json.dumps({"error_code": error_code, "error_message": error_message})
        self.response = make_response(response, status_code)