package com.example.project.service;

import com.example.project.model.dto.UserDto;
import com.example.project.model.dto.UserProfileDto;
import com.example.project.model.dto.UserRegisterDto;

public interface UserService {

    boolean register(UserRegisterDto userRegisterDto);

    UserProfileDto findUserByEmail(String email);

    void changeUserProfile(UserProfileDto userProfileDto);

    void editUserByAdmin(UserDto userDto);
    void deleteUserByAdmin(Long id);

}
