package com.bisoyi.helloapp.service.impl;

import com.bisoyi.helloapp.domain.Task;
import com.bisoyi.helloapp.repository.TaskRepository;
import com.bisoyi.helloapp.service.TaskService;
import com.bisoyi.helloapp.service.dto.TaskDTO;
import com.bisoyi.helloapp.service.mapper.TaskMapper;
import com.bisoyi.helloapp.web.rest.exception.TaskNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    @Override
    public List<TaskDTO> findAll() {
        return taskMapper.toDtoList(taskRepository.findAll());
    }

    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(taskDTO)));
    }

    @Override
    public TaskDTO update(Integer id, TaskDTO taskDTO) {
        var task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new TaskNotFoundException("Task Id : " + id + " not found");
        }
        Task entity = task.get();
        entity.setDescription(taskDTO.getDescription());
        entity.setTitle(taskDTO.getTitle());
        entity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        entity.setIsCompleted(taskDTO.getIsCompleted());
        return taskMapper.toDto(taskRepository.save(entity));
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDTO findById(Integer id) {
        return taskMapper.toDto(taskRepository.findById(id).orElse(null));
    }
}
