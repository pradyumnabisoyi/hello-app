package com.bisoyi.helloapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String email;
    private String password;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<TaskDTO> tasks = new ArrayList<>();
}
