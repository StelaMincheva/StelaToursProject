package com.example.project.web;

import com.example.project.service.SeasonalDestinationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class SeasonalDestinationRestController {

    private final SeasonalDestinationService seasonalDestinationService;


    public SeasonalDestinationRestController(SeasonalDestinationService seasonalDestinationService) {
        this.seasonalDestinationService = seasonalDestinationService;
    }

    @GetMapping("/api/")
    public ResponseEntity<Void> deleteSeasonalDestination(@RequestParam Long id) {
        seasonalDestinationService.deleteSeasonalDestination(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);

    }
}
