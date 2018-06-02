/*
CREATE DATABASE IF NOT EXISTS spring_cloud_oauth
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
*/
	
CREATE TABLE IF NOT EXISTS "user" (
  username character varying(50) NOT NULL PRIMARY KEY,
  name character varying(50) NOT NULL,
  email character varying(50) NOT NULL,
  password character varying(500) NOT NULL,
  activated boolean DEFAULT FALSE,
  activationkey character varying(50) DEFAULT NULL,
  resetpasswordkey character varying(50) DEFAULT NULL,
  CONSTRAINT user_unique UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS authority (
  name character varying(50) NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS user_authority (
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES "user" (username),
    FOREIGN KEY (authority) REFERENCES authority (name),
	PRIMARY KEY(username, authority)
);

CREATE TABLE IF NOT EXISTS oauth_access_token (
  token_id character varying(256) DEFAULT NULL,
  token bytea,
  authentication_id character varying(256) DEFAULT NULL,
  user_name character varying(256) DEFAULT NULL,
  client_id character varying(256) DEFAULT NULL,
  authentication bytea,
  refresh_token character varying(256) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id character varying(256) DEFAULT NULL,
  token bytea,
  authentication bytea
);

CREATE TABLE IF NOT EXISTS  oauth_client_details (
  client_id character varying(255) PRIMARY KEY,
  resource_ids character varying(255),
  client_secret character varying(255),
  scope character varying(255),
  authorized_grant_types character varying(255),
  web_server_redirect_uri character varying(255),
  authorities character varying(255),
  access_token_validity integer,
  refresh_token_validity integer,
  additional_information character varying(4096),
  autoapprove character varying(255)
);