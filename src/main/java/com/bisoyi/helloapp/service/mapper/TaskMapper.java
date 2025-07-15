package com.bisoyi.helloapp.service.mapper;

import com.bisoyi.helloapp.domain.Task;
import com.bisoyi.helloapp.service.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TaskMapper implements EntityMapper<Task, TaskDTO> {
    @Override
    public TaskDTO toDto(Task entity) {
        if (entity == null) {
            return null;
        }
        TaskDTO dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setIsCompleted(entity.getIsCompleted());
        return dto;
    }

    @Override
    public Task toEntity(TaskDTO dto) {
        if (dto == null) {
            return null;
        }
        Task entity = new Task();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        if (dto.getId() != null) {
            entity.setId(dto.getId());
            entity.setCreatedAt(dto.getCreatedAt());
            entity.setUpdatedAt(dto.getUpdatedAt());
        } else {
            entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            entity.setUpdatedAt(entity.getCreatedAt());
        }
        entity.setIsCompleted(dto.getIsCompleted());
        return entity;
    }
}
