package com.example.project.service.impl;

import com.example.project.model.dto.UserDto;
import com.example.project.model.dto.UserProfileDto;
import com.example.project.model.dto.UserRegisterDto;
import com.example.project.model.entity.Role;
import com.example.project.model.entity.User;
import com.example.project.model.enums.UserRole;
import com.example.project.repository.RoleRepository;
import com.example.project.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    private UserServiceImpl userServiceToTest;

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private ModelMapper mockModelMapper;

    @BeforeEach
    void setUp() {
        userServiceToTest = new UserServiceImpl(mockUserRepository, mockPasswordEncoder,
                mockRoleRepository, mockModelMapper);
    }

    @Test
    void testDeleteUserByAdmin() {
        userServiceToTest.deleteUserByAdmin(1234L);
    }

    @Test
    void testFindUserByEmail() {
        Assertions.assertNull(userServiceToTest.findUserByEmail("email"));
    }

    @Test
    void testFindById() {
        Assertions.assertNull(userServiceToTest.findById(123456L));
        Assertions.assertNull(userServiceToTest.findById(-123456L));
    }

    @Test
    void testFindAll() {
        List<User> mockUsers = new ArrayList<>();

        User mockUser1 = new User();
        mockUser1.setId(1L);
        mockUser1.setEmail("test1@email");

        User mockUser2 = new User();
        mockUser2.setId(2L);
        mockUser2.setEmail("test2@email");

        mockUsers.add(mockUser1);
        mockUsers.add(mockUser2);

        when(mockUserRepository.findAll())
                .thenReturn(mockUsers);

        List<User> testUsers = userServiceToTest.findAll();

        Assertions.assertEquals(testUsers, mockUsers);
    }

    @Test
    void testEditUserByAdmin() {
        List<Role> roles = new ArrayList<>();

        Role role1 = new Role();
        role1.setId(2L);
        role1.setUserRole(UserRole.USER);
        roles.add(role1);

        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setFirstName("firstName");
        userDto.setLastName("lastName");
        userDto.setPhoneNumber("123456");
        userDto.setBirthDate(LocalDate.parse("1989-12-12"));
        userDto.setRoles(roles);

        User user = createUser();

        when(mockUserRepository.findById(1L))
                .thenReturn(Optional.of(user));

        when(mockRoleRepository.findByUserRole(UserRole.USER))
                .thenReturn(role1);

        userServiceToTest.editUserByAdmin(userDto);

        Assertions.assertEquals(userDto.getFirstName(), user.getFirstName());
        Assertions.assertEquals(userDto.getLastName(), user.getLastName());
        Assertions.assertEquals(userDto.getPhoneNumber(), user.getPhoneNumber());
        Assertions.assertEquals(userDto.getBirthDate(), user.getBirthDate());
        Assertions.assertTrue(user.getRoles().contains(role1));
    }

    @Test
    void testRegisterSuccess() {
        UserRegisterDto userRegisterDto = createUserRegisterDto();

        when(mockUserRepository.existsByEmail(userRegisterDto.getEmail()))
                .thenReturn(false);

        when(mockUserRepository.count())
                .thenReturn(0L);

        boolean result = userServiceToTest.register(userRegisterDto);

        Assertions.assertTrue(result);
    }

    @Test
    void testRegisterPasswordNoMatch() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setPassword("test");
        userRegisterDto.setPasswordConfirm("test1");

        boolean result = userServiceToTest.register(userRegisterDto);

        Assertions.assertFalse(result);
    }

    @Test
    void testRegisterUserAlreadyExist() {
        UserRegisterDto userRegisterDto = createUserRegisterDto();

        when(mockUserRepository.existsByEmail(userRegisterDto.getEmail()))
                .thenReturn(true);

        boolean result = userServiceToTest.register(userRegisterDto);

        Assertions.assertFalse(result);
    }

    @Test
    void testChangeUserProfile() {
        UserProfileDto userProfileDto = createUserProfileDto();

        User existingUser = new User();
        existingUser.setEmail("test@email");

        when(mockUserRepository.findByEmail("test@email"))
                .thenReturn(Optional.of(existingUser));

        userServiceToTest.changeUserProfile(userProfileDto);

        Assertions.assertEquals("firstName", existingUser.getFirstName());
        Assertions.assertEquals("lastName", existingUser.getLastName());
        Assertions.assertEquals("123456", existingUser.getPhoneNumber());
        Assertions.assertEquals(userProfileDto.getBirthdate(), existingUser.getBirthDate());
    }

    private UserProfileDto createUserProfileDto() {
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setEmail("test@email");
        userProfileDto.setFirstName("firstName");
        userProfileDto.setLastName("lastName");
        userProfileDto.setPhoneNumber("123456");
        userProfileDto.setBirthdate(LocalDate.parse("1989-10-10"));
        return userProfileDto;
    }

    private UserRegisterDto createUserRegisterDto() {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setFirstName("firstName");
        userRegisterDto.setLastName("lastName");
        userRegisterDto.setEmail("test@email");
        userRegisterDto.setPassword("test");
        userRegisterDto.setPasswordConfirm("test");
        return userRegisterDto;
    }

    private User createUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("test");
        user.setLastName("test");
        user.setPhoneNumber("123123");
        user.setBirthDate(LocalDate.parse("1989-10-10"));
        return user;
    }





}
