package com.example.project.service;

import com.example.project.model.dto.UserRegisterDto;

public interface UserService {

    boolean register(UserRegisterDto userRegisterDto);
}
