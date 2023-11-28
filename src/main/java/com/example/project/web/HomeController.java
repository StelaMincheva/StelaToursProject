package com.example.project.web;

import com.example.project.model.dto.AllSeasonalDestinationsDto;
import com.example.project.model.dto.ReservationAddDto;
import com.example.project.service.ReservationService;
import com.example.project.service.SeasonalDestinationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final SeasonalDestinationService seasonalDestinationService;

    private final ReservationService reservationService;

    public HomeController(SeasonalDestinationService seasonalDestinationService, ReservationService reservationService) {
        this.seasonalDestinationService = seasonalDestinationService;
        this.reservationService = reservationService;
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

    @GetMapping("/reservation-form")
    public ModelAndView reservation(@ModelAttribute("reservationAddDto") ReservationAddDto reservationAddDto) {
        return new ModelAndView("reservation-form");
    }

    @PostMapping("/reservation-form")
    public ModelAndView reservation(@ModelAttribute("reservationAddDto") @Valid ReservationAddDto reservationAddDto,
                                    BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ModelAndView("reservation-form");
        }

        reservationService.addReservation(reservationAddDto);
        return new ModelAndView("redirect:/home");
    }





}
