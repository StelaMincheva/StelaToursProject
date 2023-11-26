package com.example.project.web;

import com.example.project.model.dto.AllSeasonalDestinationsDto;
import com.example.project.service.SeasonalDestinationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final SeasonalDestinationService seasonalDestinationService;

    public HomeController(SeasonalDestinationService seasonalDestinationService) {
        this.seasonalDestinationService = seasonalDestinationService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        AllSeasonalDestinationsDto allSeasonalDestinations = seasonalDestinationService.getAllSeasonalDestinations();
        return new ModelAndView("index", "viewSeasonalDestinations", allSeasonalDestinations );
    }

   @GetMapping("/home")
    public ModelAndView home() {
       AllSeasonalDestinationsDto allSeasonalDestinations = seasonalDestinationService.getAllSeasonalDestinations();
       return new ModelAndView("index", "viewSeasonalDestinations", allSeasonalDestinations );
   }

    @GetMapping("/about")
    public ModelAndView about() {
        return new ModelAndView("about");
    }

    @GetMapping("/contacts")
    public ModelAndView viewContacts() {
        return new ModelAndView("contact");
    }


    @GetMapping("/profile")
    public ModelAndView profile() {
        return new ModelAndView("profile");
    }





}
