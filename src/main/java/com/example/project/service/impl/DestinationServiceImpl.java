package com.example.project.service.impl;

import com.example.project.model.dto.AllDestinationsDto;
import com.example.project.model.dto.DestinationAddDto;
import com.example.project.model.dto.DestinationDto;
import com.example.project.model.entity.Destination;
import com.example.project.model.entity.Image;
import com.example.project.model.entity.Offer;
import com.example.project.repository.DestinationRepository;
import com.example.project.repository.OfferRepository;
import com.example.project.service.DestinationService;
import com.example.project.service.ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@Service
public class DestinationServiceImpl implements DestinationService {

    private static final String FOLDER_PATH = "destinationImages/";

    private final DestinationRepository destinationRepository;
    private final ImageService imageService;

    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;


    public DestinationServiceImpl(DestinationRepository destinationRepository, ImageService imageService,
                                  ModelMapper modelMapper, OfferRepository offerRepository) {
        this.destinationRepository = destinationRepository;
        this.imageService = imageService;
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
    }

    @Override
    public void addDestination(DestinationAddDto destinationAddDto) {
        Destination destination = modelMapper.map(destinationAddDto, Destination.class);

        MultipartFile imageToGet = destinationAddDto.getDestinationImage();
        String pathFile = imageService.getPath(FOLDER_PATH,
                destinationAddDto.getDestinationImage().getOriginalFilename(), imageToGet);

        Image image = imageService.create(imageToGet, pathFile);
        destination.setDestinationImage(image);

        destinationRepository.save(destination);
    }

    @Override
    public AllDestinationsDto getAllDestinations() {
        List<Destination> allDestinations = destinationRepository.findAll();

        List<DestinationDto> destinations = new ArrayList<>();

        for(Destination destination : allDestinations) {
            DestinationDto destinationDto = modelMapper.map(destination, DestinationDto.class);
            destinationDto.setUrl(destination.getDestinationImage().getUrl());
            destinations.add(destinationDto);
        }

        return new AllDestinationsDto(destinations);
    }

    @Override
    public void deleteDestination(Long id) {
        Destination destination = destinationRepository.findById(id).get();
        List<Offer> offers = offerRepository.findByDestination_Country(destination.getCountry());
        offerRepository.deleteAll(offers);
        destination.setOffers(null);
        destinationRepository.save(destination);

        destinationRepository.delete(destination);
    }

}
