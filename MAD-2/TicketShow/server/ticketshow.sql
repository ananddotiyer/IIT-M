-- Create the 'theatre' table
CREATE TABLE audit (
    id INTEGER PRIMARY KEY AUTOINCREMENT, 
    u_id VARCHAR(20),
    op VARCHAR(25),
    op_date DATETIME
);

-- Create the 'theatre' table
CREATE TABLE theatre (
    t_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(20),
    place VARCHAR(50),
    capacity INTEGER,
    image_url VARCHAR(50)
);

-- Create the 'show' table
CREATE TABLE show (
    s_id INTEGER PRIMARY KEY AUTOINCREMENT,
    t_id INTEGER,
    t_name VARCHAR(50),
    current BOOLEAN,
    name VARCHAR(30),
    rating FLOAT,
    tag1 VARCHAR(10),
    tag2 VARCHAR(10),
    tag3 VARCHAR(10),
    price NUMERIC(5, 2),
    start INTEGER,
    duration INTEGER,
    availability INTEGER,
    image_url VARCHAR(50),
    FOREIGN KEY (t_id) REFERENCES theatre(t_id)
);

-- Create the 'showdate' table
CREATE TABLE showdate (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    s_id INTEGER,
    t_id INTEGER,
    s_date DATETIME,
    availability INTEGER,
    FOREIGN KEY (s_id) REFERENCES show(s_id),
    FOREIGN KEY (t_id) REFERENCES theatre(t_id)        
);

-- Create the 'user' table
CREATE TABLE user (
    u_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(20),
    email VARCHAR(40),
    password VARCHAR(12),
    role BOOLEAN
);

-- Create the 'booking' table
CREATE TABLE booking (
    b_id INTEGER PRIMARY KEY AUTOINCREMENT, 
    u_id VARCHAR(20),
    s_id INTEGER,
    t_id INTEGER,
    date DATETIME,
    month INTEGER,
    seats INTEGER,
    cost NUMERIC(8, 2),
    FOREIGN KEY (s_id) REFERENCES show(s_id),
    FOREIGN KEY (t_id) REFERENCES theatre(t_id)
);

-- Create the 'rating' table
CREATE TABLE rating (
    r_id INTEGER PRIMARY KEY AUTOINCREMENT, 
    u_id VARCHAR(20),
    s_id INTEGER,
    t_id INTEGER,
    date DATETIME,
    month INTEGER,
    rating INTEGER,
    FOREIGN KEY (s_id) REFERENCES show(s_id),
    FOREIGN KEY (t_id) REFERENCES theatre(t_id),
    CHECK (rating >= 1 AND rating <= 5)
);
