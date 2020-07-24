CREATE DATABASE news_portal;
\c news_portal;
CREATE TABLE departments (id serial PRIMARY KEY, name VARCHAR, description VARCHAR, noofemployees INTEGER);
CREATE TABLE news (id serial PRIMARY KEY, content VARCHAR, author VARCHAR, createdat BIGINT, departmentid INTEGER, type VARCHAR);
CREATE TABLE users (id serial PRIMARY KEY, name VARCHAR, role VARCHAR, departmentid INTEGER);
CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;