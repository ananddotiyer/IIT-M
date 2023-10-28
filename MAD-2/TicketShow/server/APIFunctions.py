import os
import datetime

from models import *

from flask import jsonify
from cache_instance import current_cache_inst as cache

@cache.memoize(timeout=120)
def getAllTheatreDetails(name, place, capacity):
    query = Theatre.query

    if name:
        query = query.filter(Theatre.name == name)
    if place:
        query = query.filter(Theatre.place == place)
    if capacity:
        query = query.filter(Theatre.capacity == capacity)

    theatres = query.all()

    result = []
    for theatre in theatres:
        result.append({"t_id": theatre.t_id, 
                       "name": theatre.name, 
                       "place": theatre.place, 
                       "capacity": theatre.capacity,
                       "image_url": theatre.image_url
                       })

    return jsonify(
        {"theatres": result})

# @cache.memoize(timeout=120)
def getTheatreDetails(id):
    theatre = Theatre.query.filter_by(t_id=id).first()
    
    result = {
        "t_id": theatre.t_id, 
        "name": theatre.name, 
        "place": theatre.place, 
        "capacity": theatre.capacity,
        "image_url": theatre.image_url
        }

    return jsonify(
        {"result": result})

def getShowDetails(id):
    show = Show.query.filter_by(s_id=id).first()
    
    show.start = f"{(show.start // 60):02d}:{(show.start % 60):02d}"
    
    result = {
        "s_id": show.s_id,
        "t_id": show.t_id, 
        "t_name": show.t_name, 
        "current": show.current,
        "name": show.name,
        "rating": show.rating,
        "tag1": show.tag1,
        "tag2": show.tag2,
        "tag3": show.tag3,
        "price": show.price,
        "start": show.start,
        "duration": show.duration,
        "availability": show.availability,
        "image_url": show.image_url
    }

    return jsonify(
        {"result": result})

@cache.memoize(timeout=120)
def getAllShowDetails(name, current, rating, tag1, tag2, tag3, availability):
    query = Show.query

    if name:
        query = query.filter(Show.name == name)
    if current:
        current = True
    else:
        current = False
    query = query.filter(Show.current == current)
    if rating:
        query = query.filter(Show.rating == rating)
    if tag1:
        query = query.filter(Show.tag1 == tag1)
    if tag2:
        query = query.filter(Show.tag2 == tag2)
    if tag3:
        query = query.filter(Show.tag3 == tag3)

    shows = query.all()

    result = []
    for show in shows:
        result.append({"s_id": show.s_id, 
                       "name": show.name, 
                       "current": show.current, 
                       "rating": show.rating, 
                       "tag1": show.tag1, 
                       "tag2": show.tag2, 
                       "tag3": show.tag3, 
                       "availability": show.availability})

    return jsonify(
        {"shows": result})

def getTheatreShowDetails(t_id, date, user):
    query = Show.query
    # if t_id is supplied, get all current shows in the specified theatre
    # if t_id is not supplied, get all current shows on all theatres.
    if t_id is not None:
        query = query.filter(Show.t_id == t_id)
    query = query.filter(Show.current == True)

    shows = query.all()
    
    result = []
    for show in shows:
        # Get the show availability from ShowDate if available
        # If not available, initialize the show availability to theatre capacity.
        try:
            showdate = ShowDate.query.filter_by(s_id=show.s_id,
                                t_id=show.t_id,
                                s_date=date).order_by(ShowDate.id.desc()).first()
            availability = showdate.availability
            print("Availability", availability)
        except:
            theatre = Theatre.query.filter_by(t_id=show.t_id).first()
            availability = theatre.capacity

        try:
            rating = Rating.query.filter_by(s_id=show.s_id,
                                t_id=show.t_id,
                                u_id=user).first()
            rating = rating.rating
            print("Rating", rating)
        except:
            rating = 5

        show.start = f"{(show.start // 60):02d}:{(show.start % 60):02d}"

        result.append({"s_id": show.s_id,
                       "t_id": show.t_id,
                       "t_name": show.t_name,
                       "image_url":show.image_url,
                       "name": show.name, 
                       "current": show.current, 
                       "rating": show.rating, 
                       "start": show.start,
                       "tag1": show.tag1, 
                       "tag2": show.tag2, 
                       "tag3": show.tag3,
                       "availability": availability,
                       "seats": 1,
                       "price": show.price,
                       "my_rating": rating})

    return jsonify(
        {"shows": result})

def exportTheatreDetails(t_id):
    shows = Show.query.filter_by(t_id=t_id, current=True).all()
    
    result = {"shows": [], "bookings": [], "ratings": []}
    for show in shows:
        show_id = show.s_id
        show_start = f"{(show.start // 60):02d}:{(show.start % 60):02d}"

        result["shows"].append({
            "s_id": show_id,
            "name": show.name,
            "rating": show.rating,
            "start": show_start,
            "tag1": show.tag1, 
            "tag2": show.tag2, 
            "tag3": show.tag3,
        })

        bookings = Booking.query.filter_by(s_id=show_id).all()
        print(f"#bookings for show {show_id}: ", len(bookings))
        for booking in bookings:
            result["bookings"].append({
                "s_id": booking.s_id,
                "user": booking.u_id, 
                "date": booking.date,
                "seats": booking.seats,
                "cost": booking.cost
            })

        ratings = Rating.query.filter_by(s_id=show_id).all()
        print(f"#ratings for show {show_id}: ", len(ratings))
        for rating in ratings:
            result["ratings"].append({
                "s_id": rating.s_id,
                "user": rating.u_id, 
                "date": rating.date,
                "rating": rating.rating
            })

    return {"export_details": result}