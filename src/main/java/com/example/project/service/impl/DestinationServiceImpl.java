package com.example.project.service.impl;

import com.example.project.model.dto.DestinationAddDto;
import com.example.project.model.entity.Country;
import com.example.project.model.entity.Destination;
import com.example.project.model.entity.Image;
import com.example.project.repository.CountryRepository;
import com.example.project.repository.DestinationRepository;
import com.example.project.repository.ImageRepository;
import com.example.project.service.DestinationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {

    private final DestinationRepository destinationRepository;


    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public void addDestination(DestinationAddDto destinationAddDto) {

    }


}
