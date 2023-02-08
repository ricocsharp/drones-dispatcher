package com.musalasoft.dronesdispatcher.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "shipmentitems")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medication_id", nullable = false)
    private Medication medication;
    private Double quantity;
    @ManyToOne
    Shipment shipment;
}
