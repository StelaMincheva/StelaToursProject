package com.example.project.service.impl;

import com.example.project.model.dto.UserRegisterDto;
import com.example.project.model.entity.Role;
import com.example.project.model.entity.User;
import com.example.project.model.enums.UserRole;
import com.example.project.repository.RoleRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
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

        Role adminRole = roleRepository.findByUserRole(UserRole.ADMIN);
        Role userRole = roleRepository.findByUserRole(UserRole.USER);

        User user = new User();
        user.setFirstName(userRegisterDto.getFirstName());
        user.setLastName(userRegisterDto.getLastName());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        user.addRole(userRole);

        if (userRepository.count() == 0) {
            user.addRole(adminRole);
        }

        userRepository.save(user);
        return true;
    }

}
