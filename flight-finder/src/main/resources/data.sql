INSERT INTO user (username, password, first_name, last_name, dob, gender, mobile_number, email, city, state, zip_code)
VALUES
    ('john2004', '', 'John', 'Reed', '2004-01-01', 'M', '+1(408) 480-8040', 'asdf@asdf.com', 'Cupertino', 'CA', '95014'),
    ('becky2000', '', 'Becky', 'Robinson', '2000-11-10', 'F', '+1(669) 285-9070', 'asdf@asdf.com', 'Milpitas', 'CA', '95035'),
    ('bob1993', '', 'Bob', 'Davidson', '1993-12-06', 'M', '+1(219) 283-8973', 'asdf@asdf.com', 'Atlanta', 'GA', '39842'),
    ('viratkohli1992', '', 'Virat', 'Kohli', '1992-09-09', 'M', '+1(478) 438-2398', 'asdf@asdf.com', 'New York City', 'NY', '23873'),
    ('imbenreed34', '', 'Ben', 'Reed', '1987-08-30', 'M', '+1(615) 874-5977', 'asdf@asdf.com', 'Nashville', 'TN', '37011'),
    ('mikewu', '$2a$10$DFdRPhkntLjBVQK537vSueWF3roCmZXrWqqnjyVDmeR.FI0pRZ1Ny', 'Mike', 'Wu', '1973-04-23', 'M', '+1(415) 871-1097', 'asdf@asdf.com', 'San Francisco', 'CA', '94016'),
    ('immsdhoni', '', 'Mahendra', 'Dhoni', '1981-09-09', 'M', '+1(408) 983-3297', 'asdf@asdf.com', 'Los Angeles', 'CA', '98392'),
    ('rulak', '', 'Rula', 'Khayrallah', '1990-10-01', 'F', '+1(408) 398-3982', 'asdf@asdf.com', 'Los Altos', 'CA', '95214'),
    ('zoew', '', 'Zoe', 'Wang', '2001-10-19', 'F', '+1(925) 298-1983', 'asdf@asdf.com', 'New Jersey', 'NY', '39820'),
    ('gaikwadabhishek', '', 'Abhishek', 'Gaikwad', '1996-07-08', 'M', '+1(408) 922-8040', 'asdf@asdf.com', 'San Jose', 'CA', '98313')
;

INSERT INTO airline (name, website_url, contact_number)
VALUES
    ('American Airlines', 'www.aa.com', '1 (800) 433-7300'),
    ('Alaska Airlines', 'www.alaskaair.com', '1 (800) 252-7522'),
    ('Delta Air Lines', 'www.delta.com', '1 (800) 221-1212'),
    ('United Air Lines', 'www.united.com', '1 (800) 221-1212'),
    ('Canada Air', 'www.canadaair.com', '1 (800) 221-1212'),
    ('Dubai Air', 'www.dubaiair.com', '1 (800) 221-1212'),
    ('Southwest Airlines', 'www.southwest.com', '1 (800) 221-1212'),
    ('Frontier Airlines', 'www.frontier.com', '1 (800) 221-1212'),
    ('Ryan Air', 'www.ryanair.com', '1 (800) 221-1212'),
    ('Spirit Airlines', 'www.spirit.com', '1 (800) 221-1212')
;

INSERT INTO airport (name, code, city, state, zip_code)
VALUES
    ('San Jose International Airport', 'SJC', 'San Jose', 'CA', '95110'),
    ('San Francisco International Airport', 'SFO', 'San Francisco', 'CA', '94128'),
    ('Los Angeles International Airport', 'LAX', 'Los Angeles', 'CA', '90045'),
    ('Oakland International Airport', 'OAK', 'Oakland', 'CA', '94621'),
    ('Newark Liberty International Airport', 'EWR', 'Newark', 'NJ', '07114'),
    ('LaGuardia Airport', 'LGA', 'Queens', 'NY', '11371'),
    ('John F. Kennedy International Airport', 'JFK', 'Queens', 'NY', '11430'),
    ('William P. Hobby Airport', 'HOU', 'Houston', 'TX', '77061'),
    ('George Bush Intercontinental Airport', 'IAH', 'Houston', 'TX', '77032'),
    ('Dallas/Fort Worth International Airport', 'DFW', 'DFW Airport', 'TX', '75261')
;

-- INSERT INTO alert (communication_preference, flight_id, set_by_id)
-- VALUES
--     ('email', 1, 1)
-- ;

INSERT INTO itinerary (arrival_time, departure_time, arrives_at_id, departs_from_id, searched_by_id)
VALUES
    ('2022-12-10 18:00:45', '2022-12-10 14:45:00', 9, 1, 1)
;