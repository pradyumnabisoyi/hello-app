package com.bisoyi.helloapp.service.impl;

import com.bisoyi.helloapp.repository.UserRepository;
import com.bisoyi.helloapp.service.UserService;
import com.bisoyi.helloapp.service.dto.UserDTO;
import com.bisoyi.helloapp.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public void update(Integer id, UserDTO userDTO) {
        UserDTO dto = null;
        userRepository.findById(id).ifPresentOrElse(entity -> {
                    entity.setStatus(userDTO.getStatus());
                    entity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                    userRepository.save(entity);
                    userMapper.toDto(userRepository.save(entity));
            },
                () -> {throw new RuntimeException("User id : " + id + " not found");});
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findById(Integer id) {
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }

    @Override
    public UserDTO login(UserDTO user) {
        if (user == null || user.getEmail() == null || user.getPassword() == null ) {
            throw new RuntimeException("Email and Password field can't be empty");
        }
        var optionalUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(optionalUser.isPresent()) {
            return userMapper.toDto(optionalUser.get());
        } else {
            throw new RuntimeException("Invalid email or password.");
        }
    }
}
