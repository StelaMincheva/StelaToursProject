package com.example.project.web;

import com.example.project.model.entity.User;
import com.example.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
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

}
