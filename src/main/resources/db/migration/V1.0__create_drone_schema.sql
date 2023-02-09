CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE drones (
  id BIGINT NOT NULL,
   serial_number VARCHAR(100),
   model VARCHAR(255),
   weight_limit DOUBLE,
   battery_capacity DOUBLE,
   state VARCHAR(255),
   CONSTRAINT pk_drones PRIMARY KEY (id)
);