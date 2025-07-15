package com.bisoyi.helloapp.web.rest;

import com.bisoyi.helloapp.service.TaskService;
import com.bisoyi.helloapp.service.dto.TaskDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Task Resource", description = "Task APIs")
@RequiredArgsConstructor
public class TaskResource {
    private final TaskService taskService;
    @Operation(summary = "Get task details by task id", description = "input : task id, returns : task details")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "returns Task details")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @Operation(summary = "Get all task details", description = "returns : All task details")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "returns List of Task details")
    })
    @GetMapping()
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @Operation(summary = "Deletes task details by task id", description = "input : task id, removes task details")
    @ApiResponses({
            @ApiResponse(responseCode = "200")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTaskById(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(summary = "Create a new task")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "returns Task details")
    })
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(task));
    }

    @Operation(summary = "Update an existing task")
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "returns Task details after update otherwise throw exception")
    })
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Integer id, @RequestBody TaskDTO task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(task));
    }
}
