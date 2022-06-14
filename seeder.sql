DROP DATABASE journey2_db;

CREATE DATABASE IF NOT EXISTS journey2_db;


CREATE USER journey_user@localhost IDENTIFIED BY 'journey1';
GRANT ALL ON journey2_db.* TO journey_user@localhost;

USE journey2_db;

INSERT INTO users (city, state, bio,email, first_name,last_name, password, username)
VALUES
    ('Dallas', 'Texas', 'This is the biography!', 'testuser_01@email.com', 'FirstName', 'LastName', 'Password1','FirstUser')