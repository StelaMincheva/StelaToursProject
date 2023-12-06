package com.example.project.web;

import com.example.project.model.dto.UserProfileDto;
import com.example.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

   @GetMapping("/home")
    public ModelAndView home() {
       return new ModelAndView("index");
   }

    @GetMapping("/about")
    public ModelAndView about() {
        return new ModelAndView("about");
    }

    @GetMapping("/contacts")
    public ModelAndView viewContacts() {
        return new ModelAndView("contact");
    }


    @GetMapping("/profile")
    public ModelAndView profile(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("profile");

        UserProfileDto userProfileDto = userService.findUserByEmail(principal.getName());
        modelAndView.addObject("userProfileDto", userProfileDto);


        return modelAndView;
    }

    @GetMapping("/profile-change")
    public ModelAndView changeUserProfile(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("profile-change");
        UserProfileDto userProfileDto = userService.findUserByEmail(principal.getName());
        modelAndView.addObject(userProfileDto);
        return modelAndView;

    }

    @PostMapping("/profile-change")
    public ModelAndView changeUserProfile(@ModelAttribute("userProfileDto") UserProfileDto userProfileDto) {
        userService.changeUserProfile(userProfileDto);
        return new ModelAndView("redirect:/profile");

    }





}
