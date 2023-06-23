CREATE TABLE PROFILES (
                      id SERIAL PRIMARY KEY,
                      first_name VARCHAR(255) NOT NULL,
                      last_name VARCHAR(255) NOT NULL,
                      age INTEGER NOT NULL,
                      gender VARCHAR(10) NOT NULL
);

