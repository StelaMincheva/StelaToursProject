package com.example.project.web;

import com.example.project.model.entity.User;
import com.example.project.repository.UserRepository;
import com.example.project.service.RoleService;
import com.example.project.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userServiceToTest;

    @Autowired
    private RoleService roleServiceToTest;

    @Autowired
    private UserRepository userRepositoryToTest;

    @AfterEach
    void tearDown() {
        userRepositoryToTest.deleteAll();
    }

    @Test
    @WithMockUser(username = "test@email", roles = {"USER"})
    void testViewProfilesNotAdmin() throws Exception {
        mockMvc
                .perform(get("/profile-change-admin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "test@email", roles = {"ADMIN", "USER"})
    void testViewProfilesAdmin() throws Exception {
        mockMvc
                .perform(get("/profile-change-admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("profile-change-admin"));
    }

    @Test
    @WithMockUser(username = "test@email", roles = {"ADMIN", "USER"})
    void testDeleteUser() throws Exception {
        User testUser = new User();
        testUser.setFirstName("firstName");
        testUser.setLastName("lastName");
        testUser.setEmail("test@email");
        testUser.setPassword("password");

        userRepositoryToTest.saveAndFlush(testUser);

        mockMvc
                .perform(delete("/profile-change-admin/delete-user/{id}", testUser.getId())
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/profile-change-admin"));
    }

    @Test
    @WithMockUser(username = "test@email", roles = {"ADMIN", "USER"})
    void testChangeUser() throws Exception {
        User testUser = new User();
        testUser.setFirstName("firstName");
        testUser.setLastName("lastName");
        testUser.setEmail("test@email");
        testUser.setPassword("password");

        userRepositoryToTest.saveAndFlush(testUser);

        mockMvc
                .perform(get("/profile-change-admin/change-user/{id}", testUser.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("profile-change-admin-user"));

    }




}
