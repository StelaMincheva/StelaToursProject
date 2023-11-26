package com.example.project.web;

import com.example.project.model.dto.AllDestinationsDto;
import com.example.project.model.dto.AllSeasonalDestinationsDto;
import com.example.project.model.dto.DestinationAddDto;
import com.example.project.model.dto.SeasonalDestinationAddDto;
import com.example.project.service.SeasonalDestinationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeasonalDestinationController {

    private final SeasonalDestinationService seasonalDestinationService;

    public SeasonalDestinationController(SeasonalDestinationService seasonalDestinationService) {
        this.seasonalDestinationService = seasonalDestinationService;
    }

    @GetMapping("/seasonal-destination-add")
    public ModelAndView addSeasonalDestination(@ModelAttribute("seasonalDestinationAddDto") SeasonalDestinationAddDto seasonalDestinationAddDto) {
        return new ModelAndView("seasonal-destination-add");
    }

    @PostMapping("/seasonal-destination-add")
    public ModelAndView addSeasonalDestination(@ModelAttribute("seasonalDestinationAddDto") @Valid SeasonalDestinationAddDto seasonalDestinationAddDto,
                                       BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("seasonal-destination-add");
        }

        seasonalDestinationService.addSeasonalDestination(seasonalDestinationAddDto);
        return new ModelAndView("redirect:/home");
    }




}
