import datetime

from flask import session #, url_for
from flask_restful import Resource, reqparse
from flask_jwt_extended import create_access_token
from flask_jwt_extended import jwt_required #, get_jwt_identity

from models import *
from APIFunctions import *

# from flask import session, redirect, jsonify

# from flask import request, redirect

# from flask import current_app as app
# from graph import *
# from to_csv import *
# import matplotlib.pyplot as plt
# import os
# from flask_cors import cross_origin
# from cache_instance import current_cache_inst as cache
# from celery_tasks import *

######################################Authentication######################################
class LoginAPI(Resource):
    def post(self):
        login_parser = reqparse.RequestParser()
        login_parser.add_argument('username')
        login_parser.add_argument('password')

        args = login_parser.parse_args()
        si_un = args.get('username', None).lower()
        si_ps = args.get('password', None)

        record = User.query.filter_by(name=si_un, password=si_ps).first()
        role = True if record and record.role == 1 else False
        if record is not None:
            session['username'] = si_un
            access_token = create_access_token(identity=si_un, expires_delta=datetime.timedelta(hours=5))
            
            # Create an audit
            today = datetime.datetime.now().date()
            audit = Audit(u_id=si_un, op="login", op_date=today)
            db.session.add(audit)
            db.session.commit()

            return {"username": si_un, "access_token": access_token, "role": role}, 200  # Gives success response and token
        elif record is None:
            return {"username": si_un, "access_token": -1, "role": False}, 406

# Used only for a non-admin user.
class SignupAPI(Resource):
    def post(self):
        signup_parser = reqparse.RequestParser()
        signup_parser.add_argument('username')
        signup_parser.add_argument('password')
        signup_parser.add_argument('email')
        signup_parser.add_argument('role')
        args = signup_parser.parse_args()

        su_un = args.get("username", None).lower()
        su_ps = args.get("password", None)
        su_email = args.get("email", None)
        su_role = args.get("role", False)

        # creation_date = date_today()

        try:
            if su_un.strip() == "":
                raise Exception("Username can't be empty")
            new_user = User(name=su_un, password=su_ps, email=su_email, role=su_role)
            db.session.add(new_user)
            db.session.commit()
        except:
            db.session.rollback()
            return {"username": su_un, "result": -1}, 406

        return {"username": su_un, "result": 0}, 200

######################################Theatres######################################
class TheatreSearchAPI(Resource):
    @jwt_required()
    def post(self):
        cache.delete_memoized(getAllTheatreDetails)

        search_theatre_parser = reqparse.RequestParser()
        search_theatre_parser.add_argument("name")
        search_theatre_parser.add_argument("place")
        search_theatre_parser.add_argument("capacity")
        args = search_theatre_parser.parse_args()

        name = args.get("name")
        place = args.get("place")
        capacity = args.get("capacity")

        results = getAllTheatreDetails(name, place, capacity)  # Cached result

        return results

class TheatreEditAPI(Resource):
    @jwt_required()
    def get(self, id):
        return getTheatreDetails(id)
    
    @jwt_required()
    def patch(self, id):
        print("In patch")

        cache.delete_memoized(getTheatreDetails)
        cache.delete_memoized(getAllTheatreDetails)

        edit_theatre_parser = reqparse.RequestParser()
        edit_theatre_parser.add_argument("name")
        edit_theatre_parser.add_argument("place")
        edit_theatre_parser.add_argument("capacity")
        edit_theatre_parser.add_argument("image_url")
        args = edit_theatre_parser.parse_args()

        try:
            theatre = Theatre.query.filter_by(t_id=id).first()
            if args['name'] is not None:
                theatre.name = args['name']
            if args['place'] is not None:
                theatre.place = args['place']
            if args['capacity'] is not None:
                theatre.capacity = int(args['capacity'])
            if args['image_url'] is not None:
                theatre.image_url = args['image_url']

            db.session.commit()
            return {"result": 0}
        except Exception as e:
            db.session.rollback()
            return {"result": e}, 500

class TheatresAPI(Resource):
    @jwt_required()
    def post(self):

        cache.delete_memoized(getAllTheatreDetails)

        create_theatre_parser = reqparse.RequestParser()
        create_theatre_parser.add_argument("name")
        create_theatre_parser.add_argument("place")
        create_theatre_parser.add_argument("capacity")
        create_theatre_parser.add_argument("image_url")
        args = create_theatre_parser.parse_args()

        try:
            name = args.get("name", None)
            place = args.get("place", None)
            capacity = args.get("capacity", 100)
            image_url = args.get("image_url", None)

            record = Theatre(name=name, place=place, capacity=capacity, image_url=image_url)
            db.session.add(record)
            db.session.commit()
            return {"result": 0}
        except Exception as e:
            db.session.rollback()
            print(e)
            return {"result": e}, 500
    
    @jwt_required()
    def delete(self, t_id):
        cache.delete_memoized(getTheatreDetails)
        cache.delete_memoized(getAllTheatreDetails)

        try:
            if Show.query.filter_by(t_id=t_id).count() > 0:
                raise ValueError("Shows exist.  Can't delete!")
            Theatre.query.filter_by(t_id=t_id).delete()
            db.session.commit()
            return {"result": 0}
        except ValueError as e:
            db.session.rollback()
            return "Shows exist.  Can't delete!", 404
        except Exception as e:
            db.session.rollback()
            return {"result": e}, 500

######################################Shows######################################
class ShowEditAPI(Resource):
    @jwt_required()
    def get(self, id):
        return getShowDetails(id)

    @jwt_required()
    def patch(self, id):
        print("In patch")
        cache.delete_memoized(getShowDetails)
        cache.delete_memoized(getAllShowDetails)

        edit_show_parser = reqparse.RequestParser()
        edit_show_parser.add_argument("name")
        edit_show_parser.add_argument("current")
        edit_show_parser.add_argument("availability")
        edit_show_parser.add_argument("image_url")
        args = edit_show_parser.parse_args()

        try:
            show = Show.query.filter_by(s_id=id).first()
            if args['name'] is not None:
                show.name = args['name']
            if args['current'] is not None:
                if args['current'] == 'True':
                    show.current = True
                elif args['current'] == 'False':
                    show.current = False
            if args['availability'] is not None:
                show.availability = args['availability']
            if args['image_url'] is not None:
                show.image_url = args['image_url']

            db.session.commit()
            return {"result": 0}
        except Exception as e:
            db.session.rollback()
            print(e)
            return {"result": e}, 500

class ShowsAPI(Resource):
    def get(self, s_id):
        return getShowDetails(s_id)
    
    @jwt_required()
    def post(self):
        cache.delete_memoized(getAllShowDetails)

        create_show_parser = reqparse.RequestParser()
        create_show_parser.add_argument("t_id")
        create_show_parser.add_argument("t_name")
        create_show_parser.add_argument("current")
        create_show_parser.add_argument("name")
        create_show_parser.add_argument("rating")
        create_show_parser.add_argument("tag1")
        create_show_parser.add_argument("tag2")
        create_show_parser.add_argument("tag3")
        create_show_parser.add_argument("price")
        create_show_parser.add_argument("start")
        create_show_parser.add_argument("duration")
        create_show_parser.add_argument("availability")     
        create_show_parser.add_argument("image_url")        
        args = create_show_parser.parse_args()

        try:
            t_id = args.get("t_id")
            t_name = args.get("t_name")
            current = bool(args.get("current"))
            name = args.get("name")
            rating = args.get("rating")
            tag1 = args.get("tag1")
            tag2 = args.get("tag2")
            tag3 = args.get("tag3")
            price = args.get("price")

            # start = datetime.datetime.strptime(args.get("start"), "%Y-%m-%d")
            time = args.get("start").split(":")
            start = int(time[0]) * 60 + int(time[1])

            duration = args.get("duration")
            availability = args.get("availability")
            image_url = args.get("image_url")
            # print(t_id, current, name, rating, tag1, tag2, tag3, price, start, duration, availability, image_url)

            record = Show(t_id=t_id, t_name=t_name, current=current, name=name, rating=rating, 
                          tag1=tag1, tag2=tag2, tag3=tag3, price=price,
                          start=start, duration=duration, availability=availability,
                          image_url=image_url)
            db.session.add(record)
            db.session.commit()
            return {"result": 0}
        except Exception as e:
            db.session.rollback()
            print(e)
            return {"result": e}, 500
    
    @jwt_required()
    def delete(self, s_id):
        cache.delete_memoized(getShowDetails)
        cache.delete_memoized(getAllShowDetails)

        try:
            if Booking.query.filter_by(s_id=s_id).count() > 0:
                raise ValueError("Bookings exist.  Can't delete!")

            Show.query.filter_by(s_id=s_id).delete()
            db.session.commit()
            return {"result": 0}
        except ValueError as e:
            db.session.rollback()
            return "Bookings exist.  Can't delete!", 404
        except Exception as e:
            db.session.rollback()
            return {"result": e}, 500

class ShowSearchAPI(Resource):
    @jwt_required()
    def post(self):
        search_show_parser = reqparse.RequestParser()
        search_show_parser.add_argument("name")
        search_show_parser.add_argument("current")
        search_show_parser.add_argument("rating")
        search_show_parser.add_argument("tag1")
        search_show_parser.add_argument("tag2")
        search_show_parser.add_argument("tag3")
        search_show_parser.add_argument("availability")
        args = search_show_parser.parse_args()

        name = args.get("name")
        current = args.get("current")
        rating = args.get("rating")
        tag1 = args.get("tag1")
        tag2 = args.get("tag2")
        tag3 = args.get("tag3")
        availability = args.get("availability")

        # print(current, name, rating, tag1, tag2, tag3, availability)

        results = getAllShowDetails(name, current, rating, tag1, tag2, tag3, availability)  # Cached result

        return results
    
class DashboardAPI(Resource):
    @jwt_required()
    def post(self):
        theatre_show_parser = reqparse.RequestParser()
        theatre_show_parser.add_argument("t_id")
        theatre_show_parser.add_argument("date")
        theatre_show_parser.add_argument("user")
        args = theatre_show_parser.parse_args()

        t_id = args.get("t_id", None)
        date = args.get("date", None)
        user = args.get("user", None)

        print(t_id, date, user)
        results = getTheatreShowDetails(t_id, date, user)  # Cached result

        return results

######################################Booking######################################
class BookShowAPI(Resource):
    @jwt_required()
    def post(self):
        try:
            book_show_parser = reqparse.RequestParser()
            book_show_parser.add_argument("u_id")
            book_show_parser.add_argument("s_id")
            book_show_parser.add_argument("t_id")
            book_show_parser.add_argument("date")
            book_show_parser.add_argument("month")
            book_show_parser.add_argument("seats")
            book_show_parser.add_argument("cost")
            args = book_show_parser.parse_args()

            u_id = args.get("u_id")
            s_id = args.get("s_id")
            t_id = args.get("t_id")
            date = datetime.datetime.strptime(args.get("date"), "%Y-%m-%dT%H:%M:%S.%fZ")
            month = args.get("month")
            seats = args.get("seats")
            cost = args.get("cost")

            record = Booking(u_id=u_id, s_id=s_id, t_id=t_id, date=date, month=month, 
                          seats=seats, cost=cost)
            db.session.add(record)
            db.session.commit()

            # Create an audit
            today = datetime.datetime.now().date()
            audit = Audit(u_id=u_id, op="booking", op_date=today)
            db.session.add(audit)
            db.session.commit()

            return {"result": 0}
        except Exception as e:
            db.session.rollback()
            print(e)
            return {"result": e}, 500

######################################ShowDate######################################
class ShowDateAPI(Resource):
    @jwt_required()
    def post(self):
        print("In ShowDateAPI")
        try:
            show_date_parser = reqparse.RequestParser()
            show_date_parser.add_argument("s_id")
            show_date_parser.add_argument("t_id")
            show_date_parser.add_argument("s_date")
            show_date_parser.add_argument("availability")
            args = show_date_parser.parse_args()

            s_id = args.get("s_id")
            t_id = args.get("t_id")
            availability = args.get("availability")
            s_date = datetime.datetime.strptime(args.get("s_date"), "%Y-%m-%d")
            print(s_id, t_id, s_date, availability)

            try:
                showdate = ShowDate.query.filter_by(s_id=s_id, t_id=t_id, s_date=s_date).first()
                if args['availability'] is not None:
                    print(args['availability'])
                    showdate.availability = args['availability']
                    db.session.commit()
            except:
                record = ShowDate(s_id=s_id, t_id=t_id, s_date=s_date, availability=availability)
                db.session.add(record)
                db.session.commit()

            return {"result": availability}
        except Exception as e:
            db.session.rollback()
            print(e)
            return {"result": e}, 500

######################################ShowDate######################################
class RatingAPI(Resource):
    @jwt_required()
    def post(self):
        try:
            rating_parser = reqparse.RequestParser()
            rating_parser.add_argument("s_id")
            rating_parser.add_argument("t_id")
            rating_parser.add_argument("u_id")
            rating_parser.add_argument("rating")
            args = rating_parser.parse_args()

            s_id = args.get("s_id")
            t_id = args.get("t_id")
            u_id = args.get("u_id")
            rating = args.get("rating")
            today = datetime.datetime.now().date()
            print(s_id, t_id, u_id, rating, today)

            try:
                record = Rating.query.filter_by(s_id=s_id, t_id=t_id, u_id=u_id).first()
                if rating is not None:
                    record.rating = args['rating']
                    record.date = today
                    record.month = today.month
                    db.session.commit()
            except:
                record = Rating(s_id=s_id, t_id=t_id, u_id=u_id, rating=rating, date=today, month=today.month)
                db.session.add(record)
                db.session.commit()

            return {"result": rating}
        except Exception as e:
            db.session.rollback()
            print(e)
            return {"result": e}, 500