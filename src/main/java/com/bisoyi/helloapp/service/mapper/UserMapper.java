package com.bisoyi.helloapp.service.mapper;

import com.bisoyi.helloapp.domain.User;
import com.bisoyi.helloapp.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class UserMapper implements EntityMapper<User, UserDTO> {
    private final TaskMapper taskMapper;

    @Override
    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setStatus(user.getStatus());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setTasks(taskMapper.toDtoList(user.getTasks()));
        return dto;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User entity = new User();
        entity.setEmail(userDTO.getEmail());
        entity.setStatus(userDTO.getStatus());
        entity.setPassword(userDTO.getPassword());
        if (userDTO.getId() != null) {
            entity.setId(userDTO.getId());
            entity.setCreatedAt(userDTO.getCreatedAt());
            entity.setUpdatedAt(userDTO.getUpdatedAt());
        } else {
            entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            entity.setUpdatedAt(entity.getCreatedAt());
        }
        return entity;
    }
}
