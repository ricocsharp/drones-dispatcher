package com.musalasoft.dronesdispatcher.data.entities;

import com.musalasoft.dronesdispatcher.config.DroneModelEnum;
import com.musalasoft.dronesdispatcher.config.DroneStateEnum;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "drones")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 100)
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private DroneModelEnum model;
    @Size(max = 500)
    private Double weightLimit;
    private Double batteryCapacity;
    @Enumerated(EnumType.STRING)
    private DroneStateEnum state;
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "drone")
    private Shipment shipment;

}
