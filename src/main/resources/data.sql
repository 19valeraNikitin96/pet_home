INSERT INTO LOCATIONS (id, city, district, street) VALUES
  (99999, 'Kyiv', 'Solomenskiy', 'Borshagivska');
INSERT INTO DATES (id, day, month, year) VALUES
  (99999, 20, 6, 2021);
INSERT INTO PERSONS (id, firstname, lastname, location_id) VALUES
  (99999, 'Bogdan', 'Tkach', 99999);
INSERT INTO USERS (id, username, password, person_id) VALUES
  (99999, 'Bogdan1980', '12345', 99999);
INSERT INTO ADVERTISEMENTS (id, pet_name, age, type, location_id, date_id, owner_id) VALUES
  (99999, 'Jerry', 3, 'FOUND', 99999, 99999, 99999);

INSERT INTO LOCATIONS (id, city, district, street) VALUES
  (99998, 'Kharkiv', 'Kyivskyi', 'Industrialna');
INSERT INTO DATES (id, day, month, year) VALUES
  (99998, 4, 5, 2021);
INSERT INTO PERSONS (id, firstname, lastname, location_id) VALUES
  (99998, 'Andrii', 'Bilous', 99998);
INSERT INTO USERS (id, username, password, person_id) VALUES
  (99998, 'user123', '54321', 99998);
INSERT INTO ADVERTISEMENTS (id, pet_name, age, type, location_id, date_id, owner_id) VALUES
  (99998, 'Noname', 1, 'FOUND', 99998, 99998, 99998);

INSERT INTO MESSAGES (id, seen, content, sender_id, receiver_id) VALUES
  (1, 1, 'Hello!', 99998, 99999);
INSERT INTO MESSAGES (id, seen, content, sender_id, receiver_id) VALUES
  (2, 1, 'Hi!', 99999, 99998);
INSERT INTO MESSAGES (id, seen, content, sender_id, receiver_id) VALUES
  (3, 0, 'How are you!', 99998, 99999);