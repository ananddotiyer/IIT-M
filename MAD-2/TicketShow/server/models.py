from database import db

class Audit(db.Model):
    __tablename__ = "audit"
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    u_id = db.Column(db.String(20))
    op = db.Column(db.String(50))
    op_date = db.Column(db.DateTime)

class Theatre(db.Model):
    __tablename__ = "theatre"
    t_id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    name = db.Column(db.String(20))
    place = db.Column(db.String(50))
    capacity = db.Column(db.Integer)
    image_url = db.Column(db.String(50))

class Show(db.Model):
    __tablename__ = "show"
    s_id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    t_id = db.Column(db.Integer, db.ForeignKey('theatre.t_id'))
    t_name = db.Column(db.String(70))
    current = db.Column(db.Boolean)
    name = db.Column(db.String(30))
    rating = db.Column(db.Float)
    tag1 = db.Column(db.String(10))
    tag2 = db.Column(db.String(10))
    tag3 = db.Column(db.String(10))
    price = db.Column(db.Numeric(5, 2))
    start = db.Column(db.Integer)
    duration = db.Column(db.Integer)
    availability = db.Column(db.Integer)
    image_url = db.Column(db.String(50), nullable=True)

class ShowDate(db.Model):
    __tablename__ = "showdate"
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    s_id = db.Column(db.Integer, db.ForeignKey('show.s_id'))
    t_id = db.Column(db.Integer, db.ForeignKey('theatre.t_id'))
    s_date = db.Column(db.DateTime)
    availability = db.Column(db.Integer)

class User(db.Model):
    __tablename__ = "user"
    u_id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    name = db.Column(db.String(20))
    email = db.Column(db.String(40))
    password = db.Column(db.String(12))
    role = db.Column(db.Boolean)

    def __init__(self, name, email, password, role):
        self.name = name
        self.email = email
        self.password = password
        self.role = role

class Booking(db.Model):
    __tablename__ = "booking"
    b_id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    u_id = db.Column(db.String(20))
    s_id = db.Column(db.Integer, db.ForeignKey('show.s_id'))
    t_id = db.Column(db.Integer, db.ForeignKey('theatre.t_id'))
    date = db.Column(db.DateTime)
    month = db.Column(db.Integer)
    seats = db.Column(db.Integer)
    cost = db.Column(db.Numeric(8, 2))

class Rating(db.Model):
    __tablename__ = "rating"
    r_id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    u_id = db.Column(db.String(20))
    s_id = db.Column(db.Integer, db.ForeignKey('show.s_id'))
    t_id = db.Column(db.Integer, db.ForeignKey('theatre.t_id'))
    date = db.Column(db.DateTime)
    month = db.Column(db.Integer)
    rating = db.Column(db.Integer)
