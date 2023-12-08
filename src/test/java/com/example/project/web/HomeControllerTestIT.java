package com.example.project.web;

import com.example.project.model.dto.UserProfileDto;
import com.example.project.model.entity.Role;
import com.example.project.model.entity.User;
import com.example.project.model.enums.UserRole;
import com.example.project.repository.RoleRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;



import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userServiceToTest;
    @Autowired
    private UserRepository userRepositoryToTest;

    @Autowired
    private RoleRepository roleRepositoryToTest;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testAboutPage() throws Exception {
        mockMvc
                .perform(get("/about"))
                .andExpect(status().isOk())
                .andExpect(view().name("about"));
    }

    @Test
    void testContactsPage() throws Exception {
        mockMvc
                .perform(get("/contacts"))
                .andExpect(status().isOk())
                .andExpect(view().name("contact"));
    }

    @Test
    void testHomePage() throws Exception {
        mockMvc
                .perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void testIndexPage() throws Exception {
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

 














}
