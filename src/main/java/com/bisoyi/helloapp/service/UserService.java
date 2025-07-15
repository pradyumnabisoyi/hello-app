package com.bisoyi.helloapp.service;


import com.bisoyi.helloapp.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDTO save(UserDTO userDTO);

    void update(Integer id, UserDTO userDTO);

    void delete(Integer id);

    UserDTO findById(Integer id);

    UserDTO login(UserDTO user);
}
