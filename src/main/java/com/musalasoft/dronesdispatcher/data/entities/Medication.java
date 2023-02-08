package com.musalasoft.dronesdispatcher.data.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "medications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp="^[a-zA-Z0-9_-]*$",message=" The name field must be letters, numbers, underscores, and dashes")
    private String name;
    private Double weight;
    @Pattern(regexp="^[A-Z0-9_-]*$",message=" the code allowed only upper case letters, underscore and numbers")
    private String code;
    @Lob
    @Column(name = "medicationimage", length = 1000, columnDefinition="BLOB")
    private byte[] medicationImage;
 }
