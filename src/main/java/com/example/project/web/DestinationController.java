package com.example.project.web;

import com.example.project.model.dto.AllDestinationsDto;
import com.example.project.model.dto.DestinationAddDto;
import com.example.project.service.DestinationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }


    @GetMapping("/destinations")
    public ModelAndView viewDestinations() {
        AllDestinationsDto allDestinations = destinationService.getAllDestinations();
        return new ModelAndView("destinations", "viewDestinations", allDestinations);
    }

    @GetMapping("/destination-add")
    public ModelAndView addDestination(@ModelAttribute("destinationAddDto") DestinationAddDto destinationAddDto) {
        return new ModelAndView("destination-add");
    }

    @PostMapping("/destination-add")
    public ModelAndView addDestination(@ModelAttribute("destinationAddDto") @Valid DestinationAddDto destinationAddDto,
                                       BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("destination-add");
        }

        destinationService.addDestination(destinationAddDto);
        return new ModelAndView("redirect:/destinations");
    }

}
