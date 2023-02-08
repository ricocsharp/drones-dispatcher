package com.musalasoft.dronesdispatcher.data.mapper;

import com.musalasoft.dronesdispatcher.data.dto.MedicationDto;
import com.musalasoft.dronesdispatcher.data.dto.ShipmentDto;
import com.musalasoft.dronesdispatcher.data.entities.Medication;
import com.musalasoft.dronesdispatcher.data.entities.Shipment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface MedicationMapper  extends EntityMapper<MedicationDto, Medication>{
}
