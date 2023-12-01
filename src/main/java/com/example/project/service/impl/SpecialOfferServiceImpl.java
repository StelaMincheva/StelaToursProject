package com.example.project.service.impl;

import com.example.project.model.dto.*;
import com.example.project.model.entity.Image;
import com.example.project.model.entity.Offer;
import com.example.project.model.entity.SpecialOffer;
import com.example.project.repository.SeasonalDestinationRepository;
import com.example.project.repository.SpecialOfferRepository;
import com.example.project.service.ImageService;
import com.example.project.service.SpecialOfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialOfferServiceImpl implements SpecialOfferService {

    private static final String FOLDER_PATH = "specialOfferImages/";

    private final SpecialOfferRepository specialOfferRepository;
    private final ImageService imageService;
    private final ModelMapper modelMapper;
    private final SeasonalDestinationRepository seasonalDestinationRepository;

    public SpecialOfferServiceImpl(SpecialOfferRepository specialOfferRepository, ImageService imageService, ModelMapper modelMapper, SeasonalDestinationRepository seasonalDestinationRepository) {
        this.specialOfferRepository = specialOfferRepository;
        this.imageService = imageService;
        this.modelMapper = modelMapper;
        this.seasonalDestinationRepository = seasonalDestinationRepository;
    }

    @Override
    public void addSpecialOffer(SpecialOfferAddDto specialOfferAddDto) {
        SpecialOffer specialOffer = modelMapper.map(specialOfferAddDto, SpecialOffer.class);

        MultipartFile imageToGet = specialOfferAddDto.getSpecialOfferImage();
        String pathFile = imageService.getPath(FOLDER_PATH, specialOfferAddDto.getSpecialOfferImage().getOriginalFilename(), imageToGet);

        Image image = imageService.create(imageToGet, pathFile);
        specialOffer.setSpecialOfferImage(image);

        specialOfferRepository.save(specialOffer);
    }

    @Override
    public SpecialOfferDto findById(Long id) {
        SpecialOffer specialOffer = specialOfferRepository.findById(id).orElse(null);
        SpecialOfferDto specialOfferDto = modelMapper.map(specialOffer, SpecialOfferDto.class);
        specialOfferDto.setUrl(specialOffer.getSpecialOfferImage().getUrl());
        return specialOfferDto;
    }

    @Override
    public AllSpecialsOffersDto getAllSpecialOffersByTitle(String title) {
        List<SpecialOffer> allSpecialOffers = specialOfferRepository.findBySeasonalDestination_Title(title);

        List<SpecialOfferDto> specialOffers = new ArrayList<>();

        for(SpecialOffer specialOffer : allSpecialOffers) {
            SpecialOfferDto specialOfferDto = modelMapper.map(specialOffer, SpecialOfferDto.class);
            specialOfferDto.setUrl(specialOffer.getSpecialOfferImage().getUrl());
            specialOffers.add(specialOfferDto);
        }

        return new AllSpecialsOffersDto(specialOffers);
    }

    @Override
    public SpecialOffer likeSpecialOffer(Long id) {
        SpecialOffer specialOffer = specialOfferRepository.findById(id).orElse(null);

        specialOffer.setLikes(specialOffer.getLikes() + 1);
        return specialOfferRepository.save(specialOffer);
    }

    @Override
    public void deletePastSpecialOffers() {
        List<SpecialOffer> allSpecialOffers = specialOfferRepository.findAll();
        LocalDate today = LocalDate.now();

        for(SpecialOffer specialOffer : allSpecialOffers) {
            LocalDate pastDate = specialOffer.getDate();
            int compareValue = today.compareTo(pastDate);

            if (compareValue > 0) {
                specialOfferRepository.delete(specialOffer);
            }
        }

    }


}
