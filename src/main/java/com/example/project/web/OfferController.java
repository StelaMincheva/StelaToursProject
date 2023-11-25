package com.example.project.web;

import com.example.project.model.dto.OfferAddDto;
import com.example.project.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers")
    public ModelAndView viewOffers() {
        return new ModelAndView("offers");
    }

    @GetMapping("/offer-add")
    public ModelAndView addOffer(@ModelAttribute("offerAddDto") OfferAddDto offerAddDto) {
        return new ModelAndView("offer-add");
    }

    @PostMapping("/offer-add")
    public ModelAndView addOffer(@ModelAttribute("offerAddDto") @Valid OfferAddDto offerAddDto,
                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("offer-add");
        }

        offerService.addOffer(offerAddDto);
        return new ModelAndView("redirect:/offers");
    }
}
