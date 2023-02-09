
CREATE TABLE medications (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   weight DOUBLE,
   code VARCHAR(255),
   medicationimage BLOB,
   CONSTRAINT pk_medications PRIMARY KEY (id)
);