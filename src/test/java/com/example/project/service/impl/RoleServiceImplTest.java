package com.example.project.service.impl;

import com.example.project.model.entity.Role;
import com.example.project.model.enums.UserRole;
import com.example.project.repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceImplTest {

    private RoleServiceImpl roleServiceToTest;

    @Mock
    private RoleRepository roleRepositoryToTest;

    @BeforeEach
    void setUp() {
        roleServiceToTest = new RoleServiceImpl(roleRepositoryToTest);
    }

    @Test
    void testFindAll() {
        List<Role> roles = new ArrayList<>();

        Role role1 = new Role();
        role1.setId(1L);
        role1.setUserRole(UserRole.ADMIN);

        Role role2 = new Role();
        role2.setId(2L);
        role2.setUserRole(UserRole.USER);

        roles.add(role1);
        roles.add(role2);

        when(roleRepositoryToTest.findAll())
                .thenReturn(roles);

        List<Role> testRoles = roleServiceToTest.findAll();

        Assertions.assertEquals(testRoles, roles);
    }
}
