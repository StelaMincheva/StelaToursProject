package com.example.project.model.dto;

import java.util.List;

public class AllDestinationsDto {

    List<DestinationDto> destinations;

    public AllDestinationsDto(List<DestinationDto> destinations) {
        this.destinations = destinations;
    }

    public List<DestinationDto> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<DestinationDto> destinations) {
        this.destinations = destinations;
    }
}
