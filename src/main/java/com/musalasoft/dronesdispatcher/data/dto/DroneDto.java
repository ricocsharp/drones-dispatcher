package com.musalasoft.dronesdispatcher.data.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.musalasoft.dronesdispatcher.config.DroneModelEnum;
import com.musalasoft.dronesdispatcher.config.DroneStateEnum;
import com.musalasoft.dronesdispatcher.data.entities.Shipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DroneDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("serial_number")
    private String serialNumber;
    @JsonProperty("model")
    private DroneModelEnum model;
    @JsonProperty("weight_limit")
    private Double weightLimit;
    @JsonProperty("battery_capacity")
    private Double batteryCapacity;
    @JsonProperty("state")
    private DroneStateEnum state;
}
