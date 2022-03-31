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