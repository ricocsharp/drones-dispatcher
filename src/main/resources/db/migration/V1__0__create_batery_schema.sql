CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE batterychargelogs (
  id BIGINT NOT NULL,
   batery_charge_level DOUBLE,
   drone_id BIGINT NOT NULL,
   CONSTRAINT pk_batterychargelogs PRIMARY KEY (id)
);

ALTER TABLE batterychargelogs ADD CONSTRAINT FK_BATTERYCHARGELOGS_ON_DRONE FOREIGN KEY (drone_id) REFERENCES drones (id);