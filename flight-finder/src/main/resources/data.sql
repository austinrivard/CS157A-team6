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
    ('gaikwadabhishek', '', 'Abhishek', 'Gaikwad', '1996-07-08', 'M', '+1(408) 922-8040', 'asdf@asdf.com', 'San Jose', 'CA', '98313'),
    ('user', '$2a$10$DFdRPhkntLjBVQK537vSueWF3roCmZXrWqqnjyVDmeR.FI0pRZ1Ny', 'user', 'mikewu', '1996-07-08', 'M', '+1(408) 922-8040', 'asdf@asdf.com', 'San Jose', 'CA', '98313')
;

INSERT into roles (id, name)
VALUES
    (6, 'ROLE_ADMIN'),
    (11, 'ROLE_USER')
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

INSERT INTO flight(arrival_time, departure_time, flight_number, name, airline_id, arrives_at_id, departs_from_id)
VALUES
    ('2022-12-23 07:45:23', '2022-12-23 00:00:00', 'AA245', 'Boeing 747', 10, 10, 8),
    ('2022-12-24 08:49:56', '2022-12-24 03:02:04', 'AA247', 'Boeing 749', 1, 1, 9),
    ('2022-12-25 11:38:33', '2022-12-25 01:02:03', 'AA947', 'Boeing 838', 5, 4, 3),
    ('2022-12-26 20:05:25', '2022-12-26 12:20:23', 'AA761', 'Boeing 333', 7, 6, 5),
    ('2022-12-27 21:20:19', '2022-12-27 15:03:06', 'AA445', 'Boeing 989', 6, 5, 4),
    ('2022-12-28 03:39:32', '2022-12-27 19:00:00', 'AA298', 'Boeing 222', 5, 4, 3),
    ('2022-12-29 05:45:23', '2022-12-29 01:00:00', 'AA221', 'Boeing 237', 4, 3, 2),
    ('2022-12-30 04:30:59', '2022-12-30 00:09:12', 'AA926', 'Boeing 384', 3, 2, 1),
    ('2022-12-31 10:23:49', '2022-12-31 02:09:12', 'AA394', 'Boeing 404', 2, 1, 10),
    ('2022-12-25 14:32:51', '2022-12-25 08:59:59', 'AA398', 'Boeing 302', 1, 10, 9);

INSERT INTO alert (communication_preference, flight_to_track_id, set_by_id)
VALUES
    ('email', 1, 1)
;

INSERT INTO itinerary (arrival_time, departure_time, arrives_at_id, departs_from_id, searched_by_id)
VALUES
    ('2022-12-10 18:00:45', '2022-12-10 14:45:00', 9, 1, 1)
;