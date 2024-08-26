CREATE TABLE IF NOT EXISTS student
(
    id
    uuid
    PRIMARY
    KEY,
    name
    VARCHAR
(
    50
) NOT NULL,
    email VARCHAR
(
    100
) UNIQUE NOT NULL,
    age INTEGER NOT NULL,
    marks FLOAT,
    phone_number VARCHAR
(
    13
) NOT NULL
    );