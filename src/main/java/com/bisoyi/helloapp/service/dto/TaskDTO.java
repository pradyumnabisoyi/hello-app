package com.bisoyi.helloapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Integer id;
    private Integer userId;
    private String title;
    private String description;
    private String isCompleted;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
