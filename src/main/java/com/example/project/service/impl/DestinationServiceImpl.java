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
    private final CountryRepository countryRepository;
    private final ImageRepository imageRepository;

    public DestinationServiceImpl(DestinationRepository destinationRepository, CountryRepository countryRepository, ImageRepository imageRepository) {
        this.destinationRepository = destinationRepository;
        this.countryRepository = countryRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void addDestination(DestinationAddDto destinationAddDto) {
        Country country = countryRepository.findByCountryName(destinationAddDto.getCountry().getCountryName());
        Image image = imageRepository.findByUrl(destinationAddDto.getDestinationImage().getUrl());
        Optional<Destination> destinationByCountry = destinationRepository
                .findByCountry(country);
        if (destinationByCountry.isEmpty()) {
            Destination destination = new Destination();
            destination.setCountry(country);
            destination.setDestinationImage(image);

            destinationRepository.save(destination);
        }
    }


}
