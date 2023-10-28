import os
import logging
from flask_sqlalchemy import record_queries
from flask import current_app as app

def write_log(category, now):
    log = f'\n{category} ({now}):\n'
    log += '=============================\n'
    for each in record_queries.get_recorded_queries():
        log += f'{each.statement}\n'
    app.logger.info(log)

basedir = os.path.abspath(os.path.dirname(__file__))

class Config():
    DEBUG = False
    SQLITE_DB_DIR = None
    SQLALCHEMY_DATABASE_URI = None
    SQLALCHEMY_TRACK_MODIFICATIONS = False

class LocalDevelopmentConfig(Config):
    SQLITE_DB_DIR = os.path.join(basedir, "../db_directory")
    SQLALCHEMY_DATABASE_URI = "sqlite:///" + os.path.join(SQLITE_DB_DIR, "bloglite.sqlite3")
    # SQLALCHEMY_RECORD_QUERIES = True
    DEBUG = True
    UPLOAD_FOLDER = "./static/uploads"
    PP_FOLDER = "./static/pp"
    SECRET_KEY = os.environ.get('SECRET_KEY') or 'you-will-never-guess'
    # logging.basicConfig(filename='.//record.log', level=logging.CRITICAL, format=f'%(asctime)s %(levelname)s %(name)s %(threadName)s : %(message)s')

