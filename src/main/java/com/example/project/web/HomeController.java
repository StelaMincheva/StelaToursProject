package com.example.project.web;

import com.example.project.model.dto.AllSeasonalDestinationsDto;
import com.example.project.model.dto.UserProfileDto;
import com.example.project.repository.UserRepository;
import com.example.project.service.SeasonalDestinationService;
import com.example.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HomeController {

    private final SeasonalDestinationService seasonalDestinationService;
    private final UserService userService;

    public HomeController(SeasonalDestinationService seasonalDestinationService, UserService userService) {
        this.seasonalDestinationService = seasonalDestinationService;
        this.userService = userService;
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
    public ModelAndView profile(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("profile");

        UserProfileDto userProfileDto = userService.findUserByEmail(principal.getName());
        modelAndView.addObject(userProfileDto);


        return modelAndView;
    }





}
