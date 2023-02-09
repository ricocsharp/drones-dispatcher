
CREATE TABLE shipments (
  id BIGINT NOT NULL,
   eta TIMESTAMP,
   departure_date TIMESTAMP,
   drone_id BIGINT NOT NULL,
   is_in_progress BOOLEAN,
   CONSTRAINT pk_shipments PRIMARY KEY (id)
);

ALTER TABLE shipments ADD CONSTRAINT FK_SHIPMENTS_ON_DRONE FOREIGN KEY (drone_id) REFERENCES drones (id);