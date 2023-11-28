package com.example.project.web;

import com.example.project.model.dto.*;
import com.example.project.model.entity.Destination;
import com.example.project.model.entity.SeasonalDestination;
import com.example.project.repository.SeasonalDestinationRepository;
import com.example.project.service.SpecialOfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class SpecialOfferController {

    private final SpecialOfferService specialOfferService;
    private final SeasonalDestinationRepository seasonalDestinationRepository;

    public SpecialOfferController(SpecialOfferService specialOfferService, SeasonalDestinationRepository seasonalDestinationRepository) {
        this.specialOfferService = specialOfferService;
        this.seasonalDestinationRepository = seasonalDestinationRepository;
    }

    @GetMapping("/special-offer-add")
    public ModelAndView addSpecialOffer(@ModelAttribute("specialOfferAddDto") SpecialOfferAddDto specialOfferAddDto) {
        ModelAndView modelAndView = new ModelAndView("/special-offer-add");

        List<SeasonalDestination> seasonalDestinations = seasonalDestinationRepository.findAll();
        modelAndView.addObject("seasonalDestinations", seasonalDestinations);

        return modelAndView;
    }

    @PostMapping("/special-offer-add")
    public ModelAndView addSpecialOffer(@ModelAttribute("specialOfferAddDto") @Valid SpecialOfferAddDto specialOfferAddDto,
                                        BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ModelAndView("special-offer-add");
        }

        specialOfferService.addSpecialOffer(specialOfferAddDto);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/special-offers/{title}")
    public ModelAndView viewSpecialOffers(@PathVariable("title") String title) {
        AllSpecialsOffersDto allSpecialOffers = specialOfferService.getAllSpecialOffersByTitle(title);
        return new ModelAndView("special-offers", "viewSpecialOffers", allSpecialOffers);
    }

    @GetMapping("/special-offer-details/{id}")
    public ModelAndView viewSpecialOfferDetails(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("special-offer-details");

        SpecialOfferDto specialOfferDto = specialOfferService.findById(id);
        modelAndView.addObject(specialOfferDto);

        List<String> priceIncludesInfoPoints = Arrays.stream(specialOfferDto.getPriceIncludes().split(". ")).toList();
        modelAndView.addObject("priceIncludesInfoPoints", priceIncludesInfoPoints);

        List<String> priceNotIncludesInfoPoints = Arrays.stream(specialOfferDto.getPriceNotIncludes().split(". ")).toList();
        modelAndView.addObject("priceNotIncludesInfoPoints", priceNotIncludesInfoPoints);

        return modelAndView;
    }

}
