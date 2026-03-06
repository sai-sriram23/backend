-- Create and use the database
CREATE DATABASE IF NOT EXISTS cabsystemdb;
USE cabsystemdb;

-- Users table (matches Users.java entity)
CREATE TABLE IF NOT EXISTS users (
    id       BIGINT        NOT NULL AUTO_INCREMENT,
    username VARCHAR(50)   NOT NULL,
    email    VARCHAR(100)  NOT NULL UNIQUE,
    password VARCHAR(255)  NOT NULL,
    PRIMARY KEY (id)
);
