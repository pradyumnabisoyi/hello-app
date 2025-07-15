package com.bisoyi.helloapp.service.mapper;

import java.util.ArrayList;
import java.util.List;

public interface EntityMapper<Entity, DTO>  {
    DTO toDto(Entity entity);
    Entity toEntity(DTO dto);
    default List<DTO> toDtoList(List<Entity> entityList) {
        if (entityList == null) {
            return new ArrayList<>();
        }
        return entityList.stream().map(this::toDto).toList();
    }
}
