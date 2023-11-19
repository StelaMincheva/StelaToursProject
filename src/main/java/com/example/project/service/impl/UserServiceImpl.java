package com.example.project.service.impl;

import com.example.project.model.dto.UserRegisterDto;
import com.example.project.model.entity.Role;
import com.example.project.model.entity.User;
import com.example.project.model.enums.UserRole;
import com.example.project.repository.UserRepository;
import com.example.project.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public boolean register(UserRegisterDto userRegisterDto) {

        if(!userRegisterDto.getPassword().equals(userRegisterDto.getPasswordConfirm())) {
            return false;
        }

        boolean isRegistered = userRepository.existsByEmail(userRegisterDto.getEmail());
        if (isRegistered) {
            return false;
        }

        User user = new User();
        user.setFirstName(userRegisterDto.getFirstName());
        user.setLastName(userRegisterDto.getLastName());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        userRepository.save(user);
        return true;
    }

}
