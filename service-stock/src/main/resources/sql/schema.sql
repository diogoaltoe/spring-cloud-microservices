/*
CREATE DATABASE IF NOT EXISTS spring_cloud_stock
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
*/
	
CREATE TABLE IF NOT EXISTS product (
    id integer NOT NULL PRIMARY KEY,
    name character varying(50) NOT NULL,
    description character varying(255) NOT NULL,
    cost double precision NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS seq_product
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE seq_product OWNER TO postgres;