package com.example.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/contacts")
    public ModelAndView viewContacts() {
        return new ModelAndView("contact");
    }

    @GetMapping("/destinations")
    public ModelAndView viewDestinations() {
        return new ModelAndView("destinations");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        return new ModelAndView("profile");
    }

    @GetMapping("/about")
    public ModelAndView about() {
        return new ModelAndView("about");
    }















}