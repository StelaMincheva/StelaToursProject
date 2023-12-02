package com.example.project.service.impl;

import com.example.project.model.dto.*;
import com.example.project.model.entity.*;
import com.example.project.repository.SeasonalDestinationRepository;
import com.example.project.repository.SpecialOfferRepository;
import com.example.project.service.ImageService;
import com.example.project.service.SeasonalDestinationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeasonalDestinationServiceImpl implements SeasonalDestinationService {

    private static final String FOLDER_PATH = "seasonalDestinationImages/";

    private final SeasonalDestinationRepository seasonalDestinationRepository;
    private final ImageService imageService;
    private final ModelMapper modelMapper;
    private final SpecialOfferRepository specialOfferRepository;

    public SeasonalDestinationServiceImpl(SeasonalDestinationRepository seasonalDestinationRepository,
                                          ImageService imageService, ModelMapper modelMapper,
                                          SpecialOfferRepository specialOfferRepository) {
        this.seasonalDestinationRepository = seasonalDestinationRepository;
        this.imageService = imageService;
        this.modelMapper = modelMapper;
        this.specialOfferRepository = specialOfferRepository;
    }

    @Override
    public void addSeasonalDestination(SeasonalDestinationAddDto seasonalDestinationAddDto) {
        SeasonalDestination seasonalDestination = modelMapper.map(seasonalDestinationAddDto, SeasonalDestination.class);

        MultipartFile imageToGet = seasonalDestinationAddDto.getSeasonalImage();
        String pathFile = imageService.getPath(FOLDER_PATH, seasonalDestinationAddDto.getSeasonalImage().getOriginalFilename(), imageToGet);

        Image image = imageService.create(imageToGet, pathFile);
        seasonalDestination.setSeasonalImage(image);

        seasonalDestinationRepository.save(seasonalDestination);
    }

    @Override
    public AllSeasonalDestinationsDto getAllSeasonalDestinations() {
        List<SeasonalDestination> allSeasonalDestinations = seasonalDestinationRepository.findAll();

        List<SeasonalDestinationDto> seasonalDestinations = new ArrayList<>();

        for(SeasonalDestination seasonalDestination : allSeasonalDestinations) {
            SeasonalDestinationDto seasonalDestinationDto = modelMapper.map(seasonalDestination, SeasonalDestinationDto.class);
            seasonalDestinationDto.setUrl(seasonalDestination.getSeasonalImage().getUrl());
            seasonalDestinations.add(seasonalDestinationDto);
        }

        return new AllSeasonalDestinationsDto(seasonalDestinations);
    }

    @Override
    public void deleteSeasonalDestination(Long id) {
        SeasonalDestination seasonalDestination = seasonalDestinationRepository.findById(id).get();
        List<SpecialOffer> specialOffers = specialOfferRepository.findBySeasonalDestination_Title(seasonalDestination.getTitle());
        specialOfferRepository.deleteAll(specialOffers);
        seasonalDestination.setSpecialOffers(null);
        seasonalDestinationRepository.save(seasonalDestination);

        seasonalDestinationRepository.delete(seasonalDestination);
    }

}
