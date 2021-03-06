CREATE TABLE IF NOT EXISTS contacts (
id SERIAL PRIMARY KEY,
first_name TEXT NOT NULL,
last_name TEXT NOT NULL,
prefix BIGINT,
phone_number BIGINT NOT NULL,
email TEXT
);

CREATE TABLE IF NOT EXISTS contact_logs (
id SERIAL PRIMARY KEY,
contact_id BIGINT REFERENCES contacts(id),
event TEXT NOT NULL,
created_at TIMESTAMP NOT NULL,
first_name TEXT NOT NULL,
last_name TEXT NOT NULL,
prefix BIGINT,
phone_number BIGINT NOT NULL,
email TEXT
);