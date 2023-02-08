package com.musalasoft.dronesdispatcher.data.mapper;

import com.musalasoft.dronesdispatcher.data.dto.DroneDto;
import com.musalasoft.dronesdispatcher.data.dto.ShipmentDto;
import com.musalasoft.dronesdispatcher.data.entities.Drone;
import com.musalasoft.dronesdispatcher.data.entities.Shipment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ShipmentMapper extends EntityMapper<ShipmentDto, Shipment> {
}
