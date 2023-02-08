package com.musalasoft.dronesdispatcher.data.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.musalasoft.dronesdispatcher.config.DroneStateEnum;
import com.musalasoft.dronesdispatcher.data.entities.BatteryChargeLog;
import com.musalasoft.dronesdispatcher.data.entities.Shipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DroneDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("serial_number")
    private String serialNumber;
    @JsonProperty("weight_limit")
    private Double weightLimit;
    @JsonProperty("battery_capacity")
    private Double batteryCapacity;
    @JsonProperty("state")
    private DroneStateEnum state;
    @JsonProperty("charge_log")
    private BatteryChargeLog chargeLog;
    @JsonProperty("shipment")
    private Shipment shipment;
}
