package com.example.project.web;

import com.example.project.model.dto.DestinationAddDto;
import com.example.project.service.DestinationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }


    @GetMapping("/destinations")
    public ModelAndView viewDestinations() {
        return new ModelAndView("destinations");
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
