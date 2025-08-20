package com.example.urlshortner.service;

import com.example.urlshortner.dto.UserDTO;
import com.example.urlshortner.pojo.User;

import java.util.List;

public interface UserService {
    void createUser(UserDTO userDTO);
    void updateUser(Long id, UserDTO userDTO);
    UserDTO getUserbyId(Long id);
    List<UserDTO> getUsers();
}
