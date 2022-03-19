INSERT INTO LOCATIONS (id, city, district, street) VALUES
  (1, 'Kyiv', 'Solomenskiy', 'Borshagivska');
INSERT INTO DATES (id, day, month, year) VALUES
  (1, 20, 6, 2021);
INSERT INTO PERSONS (id, firstname, lastname, location_id) VALUES
  (1, 'Bogdan', 'Tkach', 1);
INSERT INTO USERS (id, username, password, person_id) VALUES
  (1, 'Bogdan1980', '12345', 1);
INSERT INTO ADVERTISEMENTS (id, pet_name, age, type, location_id, date_id, owner_id) VALUES
  (1, 'Jerry', 3, 'FOUND', 1, 1, 1);