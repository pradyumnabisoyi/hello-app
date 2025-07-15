package com.bisoyi.helloapp.service;

import com.bisoyi.helloapp.service.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> findAll();
    TaskDTO save(TaskDTO taskDTO);
    TaskDTO update(Integer id, TaskDTO taskDTO);
    void deleteTask(Integer id);
    TaskDTO findById(Integer id);
}
