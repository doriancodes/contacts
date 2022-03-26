CREATE TABLE IF NOT EXISTS contacts (
id SERIAL PRIMARY KEY,
first_name TEXT NOT NULL,
last_name TEXT NOT NULL,
prefix BIGINT,
phone_number BIGINT NOT NULL,
email TEXT
);

