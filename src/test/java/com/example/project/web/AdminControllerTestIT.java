package com.example.project.web;

import com.example.project.service.RoleService;
import com.example.project.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userServiceToTest;

    @Autowired
    private RoleService roleServiceToTest;

    @Test
    @WithMockUser(username = "test@email", roles = {"USER"})
    void testViewProfilesNotAdmin() throws Exception {
        mockMvc
                .perform(get("/profile-change-admin"))
                .andExpect(status().isForbidden());
    }




}
