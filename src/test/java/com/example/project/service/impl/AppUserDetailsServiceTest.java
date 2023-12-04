package com.example.project.service.impl;

import com.example.project.model.entity.User;
import com.example.project.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppUserDetailsServiceTest {

    private AppUserDetailsService serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new AppUserDetailsService(mockUserRepository);
    }

    @Test
    void testUserByUserNameNotExist() {
        Assertions.assertThrows(UsernameNotFoundException.class,
                () ->  serviceToTest.loadUserByUsername("test@email.com"));
    }

}
