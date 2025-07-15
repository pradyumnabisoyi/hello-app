package com.bisoyi.helloapp.repository;

import com.bisoyi.helloapp.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
