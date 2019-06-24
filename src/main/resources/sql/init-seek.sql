/* Create seek database */
CREATE DATABASE seek;

/* Create the core schema */
CREATE SCHEMA core;

/* Create the table objects */
CREATE TABLE core.company (
    /*
        todo Configure uuid-ossp so UUIDs can be generated.
        See: https://www.postgresql.org/docs/11/uuid-ossp.html
    */
    company_id uuid PRIMARY KEY,
    name varchar,
    company_url varchar,
    careers_url varchar,
    glassdoor_rating real
);

CREATE TABLE core.position (
    position_id uuid,
    company_id uuid NOT NULL,
    position_url varchar,
    rank integer,
    interview_difficulty real,
    location varchar,
    is_cover_letter boolean DEFAULT false,
    is_applied boolean DEFAULT false,
    notes varchar,
    PRIMARY KEY (position_id, company_id),
    FOREIGN KEY (company_id) REFERENCES core.company
);