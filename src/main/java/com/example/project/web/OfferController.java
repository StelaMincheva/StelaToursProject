package com.example.project.web;

import com.example.project.model.dto.AllOffersDto;
import com.example.project.model.dto.OfferAddDto;
import com.example.project.model.dto.OfferDto;
import com.example.project.model.entity.Destination;
import com.example.project.repository.DestinationRepository;
import com.example.project.service.OfferService;
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
public class OfferController {

    private final OfferService offerService;
    private final DestinationRepository destinationRepository;

    public OfferController(OfferService offerService, DestinationRepository destinationRepository) {
        this.offerService = offerService;
        this.destinationRepository = destinationRepository;
    }

    @GetMapping("/offers/{country}")
    public ModelAndView viewOffers(@PathVariable("country") String country) {
        AllOffersDto allOffers = offerService.getAllOffersByCountry(country);
        return new ModelAndView("offers", "viewOffers", allOffers);
    }

    @GetMapping("/offer-add")
    public ModelAndView addOffer(@ModelAttribute("offerAddDto") OfferAddDto offerAddDto) {

        ModelAndView modelAndView = new ModelAndView("/offer-add");

        List<Destination> destinations = destinationRepository.findAll();
        modelAndView.addObject("destinations", destinations);

        return modelAndView;
    }

    @PostMapping("/offer-add")
    public ModelAndView addOffer(@ModelAttribute("offerAddDto") @Valid OfferAddDto offerAddDto,
                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("offer-add");
        }

        offerService.addOffer(offerAddDto);
        return new ModelAndView("redirect:/destinations");
    }

    @GetMapping("/offer-details/{id}")
    public ModelAndView viewOfferDetails(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("offer-details");

        OfferDto offerDto = offerService.findById(id);
        modelAndView.addObject(offerDto);

        List<String> priceIncludesInfoPoints = Arrays.stream(offerDto.getPriceIncludes().split(". ")).toList();
        modelAndView.addObject("priceIncludesInfoPoints", priceIncludesInfoPoints);

        List<String> priceNotIncludesInfoPoints = Arrays.stream(offerDto.getPriceNotIncludes().split(". ")).toList();
        modelAndView.addObject("priceNotIncludesInfoPoints", priceNotIncludesInfoPoints);

        return modelAndView;
    }
}
