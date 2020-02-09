SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS animals(
id SERIAL PRIMARY KEY,
    animal_id int,
    animalName VARCHAR
);

CREATE TABLE IF NOT EXISTS sightings(
 id SERIAL PRIMARY KEY,
 animal_id int,
 animalLocation VARCHAR,
 rangerName VARCHAR,
 created at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS endangered_animals(
  id SERIAL PRIMARY KEY,
  animal_id int,
  animal_name VARCHAR ,
  animal_age VARCHAR,
  animal_health VARCHAR
);