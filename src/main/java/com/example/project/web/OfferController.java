package com.example.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfferController {

    @GetMapping("/offers")
    public ModelAndView viewOffers() {
        return new ModelAndView("offers");
    }

    @GetMapping("/offer-add")
    public ModelAndView addOffer() {
        return new ModelAndView("offer-add");
    }
}
