package com.example.project.web;

import com.example.project.model.dto.UserRegisterDto;
import com.example.project.model.entity.User;
import com.example.project.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository mockUserRepository;
    private UserRegisterDto userRegisterDto;

    @BeforeEach
    void setUp() {
        userRegisterDto = createUser();
    }

    @Test
    void testRegisterPage() throws Exception {
        mockMvc
                .perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    void testRegister() throws Exception {
        mockMvc
                .perform(post("/register")
                .param("firstName", userRegisterDto.getFirstName())
                .param("lastName", userRegisterDto.getLastName())
                .param("email", userRegisterDto.getEmail())
                .param("password", userRegisterDto.getPassword())
                .param("passwordConfirm", userRegisterDto.getPasswordConfirm())
                        .with(csrf()))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/login"));

        Assertions.assertEquals(1, mockUserRepository.count());

        Optional<User> testUser = mockUserRepository.findByEmail("test@email");
        Assertions.assertTrue(testUser.isPresent());

        User user = testUser.get();
        Assertions.assertEquals("test@email", user.getEmail());
    }

    @Test
    void testRegisterPasswordsNotMatch() throws Exception {
        mockMvc
                .perform(post("/register")
                                .param("firstName", userRegisterDto.getFirstName())
                                .param("lastName", userRegisterDto.getLastName())
                                .param("email", userRegisterDto.getEmail())
                                .param("password", userRegisterDto.getPassword())
                                .param("passwordConfirm", "12345")
                                .with(csrf())
                ).andExpect(status().is2xxSuccessful())
                .andExpect(view().name("register"));

        Assertions.assertEquals(0, mockUserRepository.count());
    }



    @Test
    void testLoginPage() throws Exception {
        mockMvc
                .perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }



    private UserRegisterDto createUser() {
        UserRegisterDto user = new UserRegisterDto();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("test@email");
        user.setPassword("password");
        user.setPasswordConfirm("password");
        return user;

    }



}
