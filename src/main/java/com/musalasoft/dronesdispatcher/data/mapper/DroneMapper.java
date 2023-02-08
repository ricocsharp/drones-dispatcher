package com.musalasoft.dronesdispatcher.data.mapper;

import com.musalasoft.dronesdispatcher.data.dto.DroneDto;
import com.musalasoft.dronesdispatcher.data.entities.Drone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface DroneMapper  extends EntityMapper<DroneDto, Drone>{
}
