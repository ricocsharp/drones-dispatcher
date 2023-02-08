CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE medications (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   weight DOUBLE,
   code VARCHAR(255),
   medicationimage BLOB,
   CONSTRAINT pk_medications PRIMARY KEY (id)
);