package com.musalasoft.dronesdispatcher.data.mapper;

import java.util.List;

import org.mapstruct.MappingTarget;

public interface EntityMapper<DTO, ENTITY> {

    DTO toDto(ENTITY entity);

    List<DTO> toDtoList(List<ENTITY> entities);

    ENTITY toEntity(DTO dto);

    void updateEntity(@MappingTarget ENTITY entity, DTO dto);

    List<ENTITY> toEntityList(List<DTO> dtos);

}
