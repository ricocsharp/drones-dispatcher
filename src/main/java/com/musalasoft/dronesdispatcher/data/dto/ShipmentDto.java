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
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShipmentDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("eta")
    private Date eta;
    @JsonProperty("departure_date")
    private Date departureDate;
    @JsonProperty("drone")
    private Drone drone;
    @JsonProperty("is_in_progress")
    private Boolean isInProgress;
}
