package com.example.project.service;

import com.example.project.model.dto.UserDto;
import com.example.project.model.dto.UserProfileDto;
import com.example.project.model.dto.UserRegisterDto;
import com.example.project.model.entity.User;

import java.util.List;

public interface UserService {

    boolean register(UserRegisterDto userRegisterDto);
    UserProfileDto findUserByEmail(String email);
    void changeUserProfile(UserProfileDto userProfileDto);
    UserDto findById(Long id);
    List<User> findAll();
    void editUserByAdmin(UserDto userDto);
    void deleteUserByAdmin(Long id);

}
