import datetime
from models import Audit, Show, User, Booking, Rating
from workers import celery
from celery.schedules import crontab
from mail import send_email
from jinja2 import Template
from APIFunctions import exportTheatreDetails

def format_message(template_file, data={}):
    with open(template_file) as file:
        template = Template(file.read())
        return template.render(data=data)
    
@celery.task()
def export_theatre_details(t_id):
    for i in range(100000000):
        pass
    export_details = exportTheatreDetails(t_id=t_id)
    return (export_details)

@celery.task
def check_show(id):
    show = Show.query.filter_by(s_id=id).first()
    return (f"{show.name} starts at {show.start}!")

# If the user hasn't logged in or booked a ticket, trigger the task.
@celery.task
def check_usage():
    today = datetime.datetime.now().date()
    time = datetime.time(0, 0)
    today = datetime.datetime.combine(today, time)

    result = []
    for user in User.query.all():
        try:
            _ = Audit.query.filter_by(op_date=today, u_id=user.name).first()
            if _ is None:
                result.append((user.name, False))
                # message = f"Hello {user.name}\n\n,It seems that you've not logged in today into TicketShow website"
                message = format_message("email.html", data=user)
                send_email(to=user.email, subject="TicketShow", msg=message)
            else:
                result.append((user.name, True))
        except:
            result.append((user.name, False))
    return result

# Prepare an entertainment report for each user, and send as email.
@celery.task
def entertainment_report():
    current_month = datetime.datetime.now().month

    result = []
    for user in User.query.all():
        print(user.name, current_month)
        try:
            bookings = Booking.query.filter_by(month=current_month, u_id=user.name).all()
            ratings = Rating.query.filter_by(month=current_month, u_id=user.name).all()

            # Generate the HTML report
            report = "<html><body>"
            report += "<h3>Monthly Report</h3>"

            # Bookings Table
            if len(bookings) > 0:
                report += "<h4>Bookings</h4>"
                report += "<table style='border-collapse: collapse; border: 1px solid black;'>"
                report += "<tr>"
                report += "<th style='border: 1px solid black;'>Show ID</th>"
                report += "<th style='border: 1px solid black;'>Theatre ID</th>"
                report += "<th style='border: 1px solid black;'>Date</th>"
                report += "<th style='border: 1px solid black;'>Seats</th>"
                report += "<th style='border: 1px solid black;'>Cost</th>"
                report += "</tr>"
                for booking in bookings:
                    show = Show.query.filter_by(s_id=booking.s_id).first()
                    report += "<tr>"
                    report += f"<td style='border: 1px solid black;'>{show.name}</td>"
                    report += f"<td style='border: 1px solid black;'>{show.t_name}</td>"
                    report += f"<td style='border: 1px solid black;'>{booking.date}</td>"
                    report += f"<td style='border: 1px solid black;'>{booking.seats}</td>"
                    report += f"<td style='border: 1px solid black;'>{booking.cost}</td>"
                    report += "</tr>"
                report += "</table>"
            else:
                report += "<h4>No Bookings by the user for this month</h4>"
            
            # Ratings Table
            if len(ratings) > 0:
                report += "<h4>Ratings</h4>"
                report += "<table style='border-collapse: collapse; border: 1px solid black;'>"
                report += "<tr>"
                report += "<th style='border: 1px solid black;'>Show ID</th>"
                report += "<th style='border: 1px solid black;'>Theatre ID</th>"
                report += "<th style='border: 1px solid black;'>Rating</th>"
                report += "</tr>"
                for rating in ratings:
                    show = Show.query.filter_by(s_id=rating.s_id).first()
                    report += "<tr>"
                    report += f"<td style='border: 1px solid black;'>{show.name}</td>"
                    report += f"<td style='border: 1px solid black;'>{show.t_name}</td>"
                    report += f"<td style='border: 1px solid black;'>{rating.rating}</td>"
                    report += "</tr>"
                report += "</table>"
            else:
                report += "<h4>No Ratings by the user for this month</h4>"
            report += "</body></html>"

            # Save the report to an HTML file
            with open("monthly_report.html", "w") as file:
                file.write(report)
            
            # Convert above HTML file to pdf.
            import pdfkit
            pdfkit.from_file('monthly_report.html', 'monthly_report.pdf')
            
            send_email(to=user.email, subject="TicketShow", msg=report, attachment="monthly_report.pdf")
        except:
            result.append((user.name, False))
    return result

@celery.on_after_finalize.connect
def setup_periodic_tasks(sender, **kwargs):
    # sender.add_periodic_task(
    #     crontab(hour=10, minute=24, day_of_week='*'),
    #     crontab(minute='*'),
    #     say_hello.s("10:24"),
    # )
    # sender.add_periodic_task(
    #     crontab(hour=17, minute=30),
    #     check_show.s(2),
    #     )
    sender.add_periodic_task(
        crontab(minute=0, hour=10, day_of_month=1),
        entertainment_report.s(),
        )
    sender.add_periodic_task(
        crontab(hour=17, minute=30),
        check_usage.s(),
        )
    # pass