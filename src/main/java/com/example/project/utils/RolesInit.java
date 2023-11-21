package com.example.project.utils;

import com.example.project.model.entity.Role;
import com.example.project.model.enums.UserRole;
import com.example.project.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RolesInit implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RolesInit(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Arrays.stream(UserRole.values())
                    .forEach(userRole -> {
                        Role role = new Role();
                        role.setUserRole(userRole);
                        roleRepository.save(role);
                    });
        }
    }
}
