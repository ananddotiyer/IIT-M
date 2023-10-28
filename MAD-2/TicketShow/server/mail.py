#Using MailHog
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email.encoders import *
import os

SMTP_SERVER_HOST = "localhost"
SMTP_SERVER_PORT = 1025
SENDER_ADDRESS = "no-reply@ticketshow.com"
SENDER_PASSWORD = ""


def send_email(to, subject, msg, attachment=None):
    mail = MIMEMultipart()
    mail["From"] = SENDER_ADDRESS
    mail["Subject"] = subject
    mail["To"] = to

    mail.attach(MIMEText(msg, "html"))

    if attachment is not None:
        with open(attachment, "rb") as attachment_file:
            # adding file as an output stream
            part = MIMEBase("application", "octet-stream")
            part.set_payload(attachment_file.read())
            encode_base64(part)

        part.add_header("Content-Disposition", f"attachment; filename={attachment_file}")
        mail.attach(part)

    s = smtplib.SMTP(host=SMTP_SERVER_HOST, port=SMTP_SERVER_PORT)
    s.login(SENDER_ADDRESS, SENDER_PASSWORD)
    s.send_message(mail)
    s.quit()
    # if attachment is not None:
    #     os.remove(attachment)

    return True

if __name__ == "__main__":
    send_email("ananddotiyer@gmail.com", "Ticket Show", "Ticket Show is here!", attachment="requirements.txt")

# Using GMail
# import smtplib
# from email.mime.multipart import MIMEMultipart
# from email.mime.text import MIMEText

# msg = MIMEMultipart()
# msg['From'] = 'noreply@ticketshow.com'
# msg['To'] = 'ananddotiyer@gmail.com'
# msg['Subject'] = 'simple email in python'
# message = 'here is the email'
# msg.attach(MIMEText(message))

# mailserver = smtplib.SMTP('smtp.gmail.com',587)
# # identify ourselves to smtp gmail client
# mailserver.ehlo()
# # secure our email with tls encryption
# mailserver.starttls()
# # re-identify ourselves as an encrypted connection
# mailserver.ehlo()
# mailserver.login('ananddotiyer@gmail.com', 'mmycjznhcmbazmqg')

# mailserver.sendmail('me@gmail.com','ananddotiyer@gmail.com',msg.as_string())

# mailserver.quit()