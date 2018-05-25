/*
CREATE DATABASE spring_cloud_relationship
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
*/
	
CREATE TABLE IF NOT EXISTS customer (
    id integer NOT NULL PRIMARY KEY,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL
);

ALTER TABLE customer OWNER TO postgres;

CREATE SEQUENCE IF NOT EXISTS seq_customer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;	

ALTER TABLE seq_customer OWNER TO postgres;