SET MODE PostgreSQL;

CREATE TABLE animals(
id SERIAL PRIMARY KEY,
    animal_id int,
    animalName VARCHAR
);

CREATE TABLE sightings(
 id SERIAL PRIMARY KEY,
 animal_id int,
 animalLocation VARCHAR,
 rangerName VARCHAR,
 created at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE endangered_animals(
  id SERIAL PRIMARY KEY,
  animal_id int,
  animal_name VARCHAR ,
  animal_age VARCHAR,
  animal_health VARCHAR
);