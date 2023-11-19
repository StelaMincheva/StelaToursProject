package com.example.project;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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



    @GetMapping("/profile")
    public ModelAndView profile() {
        return new ModelAndView("profile");
    }

    @GetMapping("/about")
    public ModelAndView about() {
        return new ModelAndView("about");
    }















}
