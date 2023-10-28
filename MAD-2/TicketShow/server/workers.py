from celery import Celery
from flask import current_app as app

celery = Celery("Application Jobs")

class ContextTask(celery.Task):
    def __call__(self, *args, **kwargs):
        with app.app_context():
            self.__class__
            print(f"Starting task {str(self.__class__)[14:]}")
            return self.run(*args, **kwargs)


