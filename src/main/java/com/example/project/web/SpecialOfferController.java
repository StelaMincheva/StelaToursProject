package com.example.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpecialOfferController {

    @GetMapping("/special-offer-add")
    public ModelAndView addSpecialOffer() {
        return new ModelAndView("special-offer-add");
    }

}
