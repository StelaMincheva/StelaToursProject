package com.example.project.web;

import com.example.project.service.DestinationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class DestinationRestController {

    private final DestinationService destinationService;

    public DestinationRestController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping("/api/destinations")
    public ResponseEntity<Void> deleteDestination(@RequestParam Long id) {
        destinationService.deleteDestination(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/destinations"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

}
