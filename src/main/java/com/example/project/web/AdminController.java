package com.example.project.web;

import com.example.project.model.dto.UserDto;
import com.example.project.model.entity.Role;
import com.example.project.model.entity.User;
import com.example.project.service.RoleService;
import com.example.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/profile-change-admin")
    public ModelAndView adminViewProfiles() {
       ModelAndView modelAndView = new ModelAndView("profile-change-admin");

       List<User> users = userService.findAll();

       modelAndView.addObject("users", users);
       return modelAndView;
    }

    @DeleteMapping("/profile-change-admin/delete-user/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserByAdmin(id);
        return new ModelAndView("redirect:/profile-change-admin");
    }

    @GetMapping("/profile-change-admin/change-user/{id}")
    public ModelAndView changeUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("profile-change-admin-user");

        UserDto userDto = userService.findById(id);
        List<Role> roles = roleService.findAll();

        if(userDto != null) {
            modelAndView.addObject(userDto);
            modelAndView.addObject("roles", roles);
        } else {
            throw new IllegalArgumentException("No user found!");
        }

        return modelAndView;
    }

    @PostMapping("/profile-change-admin/save-change-user/{id}")
    public ModelAndView saveChanges(@ModelAttribute("userDto") UserDto userDto) {
        userService.editUserByAdmin(userDto);
        return new ModelAndView("redirect:/profile-change-admin");
    }

}
