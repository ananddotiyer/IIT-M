sudo apt install python3-pip

pip install -r requirements.txt

sudo apt install sqlite

Use sqlite3 <db_name> to open database in command line.

.headers on (from sqlite prompt)

Install VSCode extension SQLite3 Editor by yy0931.

sudo apt install redis-server

IMPORTANT: 

## While using flask_uploads module, the following line throws import error.

from werkzeug import secure_filename, FileStorage

THis is because werkzeug seems to have secure_filename moved into utils folder, and is not fixed.  Change the above line to.

from werkzeug.utils import secure_filename
from werkzeug.datastructures import  FileStorage

## In order to kill hanging ports, run the following commands:
sudo lsof -i :5000
kill -9 <PID>

## In order to setup gmail SMTP server for emailing purposes:
Enable 2FA for the sender's gmail account.
Create app password on Windows computer.
Use this password in the script, when sending email.

## Alternatively, use the mailHog SMTP server.
Follow the instructions at https://github.com/mailhog/MailHog
sudo apt-get -y install golang-go
go install github.com/mailhog/MailHog@latest
~/go/bin/MailHog (opens up http://localhost:8025/#)

## Send entertainment report in pdf format.
pip install pdfkit
sudo apt-get install wkhtmltopdf

python3 main.py
celery -A main.celery worker -l info
celery -A main.celery beat --max-interval 1 -l info