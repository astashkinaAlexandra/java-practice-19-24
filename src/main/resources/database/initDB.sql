CREATE TABLE IF NOT EXISTS workers
(
    id    SERIAL PRIMARY KEY ,
    firstName  VARCHAR(200) NOT NULL ,
    lastName  VARCHAR(200) NOT NULL ,
    middleName  VARCHAR(200) NOT NULL
);