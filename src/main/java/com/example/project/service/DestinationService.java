package com.example.project.service;

import com.example.project.model.dto.AllDestinationsDto;
import com.example.project.model.dto.DestinationAddDto;

public interface DestinationService {

    void addDestination(DestinationAddDto destinationAddDto);
    AllDestinationsDto getAllDestinations();

    void deleteDestination(Long id);
}
