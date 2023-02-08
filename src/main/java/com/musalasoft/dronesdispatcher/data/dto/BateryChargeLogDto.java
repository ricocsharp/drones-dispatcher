package com.musalasoft.dronesdispatcher.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musalasoft.dronesdispatcher.data.entities.Drone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BateryChargeLogDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("batery_charge_level")
    private Double bateryChargeLevel;
    @JsonProperty("drone")
    private Drone drone;
}
