CREATE TABLE PROFILES (
                      id SERIAL PRIMARY KEY,
                      first_name VARCHAR(255) NOT NULL,
                      last_name VARCHAR(255) NOT NULL,
                      email varchar(255) NOT NULL,
                      age INTEGER NOT NULL,
                      gender VARCHAR(10) NOT NULL,
                      status VARCHAR (20) NOT NULL
);
CREATE UNIQUE INDEX idx_profiles ON profiles (email, status);
