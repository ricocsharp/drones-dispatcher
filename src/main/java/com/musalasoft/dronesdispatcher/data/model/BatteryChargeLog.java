package com.musalasoft.dronesdispatcher.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "batterychargelogs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatteryChargeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double bateryChargeLevel;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drone_id", nullable = false)
    private Drone drone;
}
