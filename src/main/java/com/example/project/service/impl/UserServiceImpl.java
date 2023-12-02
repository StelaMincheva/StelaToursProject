package com.example.project.service.impl;

import com.example.project.model.dto.OfferDto;
import com.example.project.model.dto.UserDto;
import com.example.project.model.dto.UserProfileDto;
import com.example.project.model.dto.UserRegisterDto;
import com.example.project.model.entity.Role;
import com.example.project.model.entity.User;
import com.example.project.model.enums.UserRole;
import com.example.project.repository.RoleRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public UserProfileDto findUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);

        UserProfileDto userProfileDto = modelMapper.map(user, UserProfileDto.class);

        return userProfileDto;
    }

    @Override
    public void changeUserProfile(UserProfileDto userProfileDto) {
        Optional<User> user = userRepository.findByEmail(userProfileDto.getEmail());

        if (!userProfileDto.getFirstName().isEmpty()) {
            user.get().setFirstName(userProfileDto.getFirstName());
        }

        if (!userProfileDto.getLastName().isEmpty()) {
            user.get().setLastName(userProfileDto.getLastName());
        }

        if (!userProfileDto.getPhoneNumber().isEmpty()) {
            user.get().setPhoneNumber(userProfileDto.getPhoneNumber());
        }

        if (userProfileDto.getBirthdate() != null) {
            user.get().setBirthDate(userProfileDto.getBirthdate());
        }

        userRepository.save(user.get());
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void editUserByAdmin(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElse(null);

        if (user != null) {
            if (!userDto.getRoles().contains(roleRepository.findByUserRole(UserRole.USER))) {
                userDto.getRoles().add(roleRepository.findByUserRole(UserRole.USER));
            }

            user.setRoles(userDto.getRoles());
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUserByAdmin(Long id) {
        userRepository.deleteById(id);

    }


}
