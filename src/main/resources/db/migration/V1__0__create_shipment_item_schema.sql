CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE shipmentitems (
  id BIGINT NOT NULL,
   medication_id BIGINT NOT NULL,
   quantity DOUBLE,
   shipment_id BIGINT,
   CONSTRAINT pk_shipmentitems PRIMARY KEY (id)
);

ALTER TABLE shipmentitems ADD CONSTRAINT FK_SHIPMENTITEMS_ON_MEDICATION FOREIGN KEY (medication_id) REFERENCES medications (id);

ALTER TABLE shipmentitems ADD CONSTRAINT FK_SHIPMENTITEMS_ON_SHIPMENT FOREIGN KEY (shipment_id) REFERENCES shipments (id);