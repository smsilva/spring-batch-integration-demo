CREATE DATABASE docker;

CREATE user silvios;
GRANT ALL PRIVILEGES ON DATABASE docker TO silvios;

ALTER USER demo WITH PASSWORD 'demo';
