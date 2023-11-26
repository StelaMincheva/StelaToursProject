package com.example.project.service.impl;

import com.example.project.model.dto.AllOffersDto;
import com.example.project.model.dto.OfferAddDto;
import com.example.project.model.dto.OfferDto;
import com.example.project.model.entity.Image;
import com.example.project.model.entity.Offer;
import com.example.project.repository.DestinationRepository;
import com.example.project.repository.OfferRepository;
import com.example.project.service.ImageService;
import com.example.project.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String FOLDER_PATH = "offerImages/";

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ImageService imageService;

    private final DestinationRepository destinationRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper,
                            ImageService imageService, DestinationRepository destinationRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.imageService = imageService;
        this.destinationRepository = destinationRepository;
    }

    @Override
    public void addOffer(OfferAddDto offerAddDto) {
        Offer offer = modelMapper.map(offerAddDto, Offer.class);

        MultipartFile imageToGet = offerAddDto.getOfferImage();
        String pathFile = imageService.getPath(FOLDER_PATH, offerAddDto.getOfferImage().getOriginalFilename(), imageToGet);

        Image image = imageService.create(imageToGet, pathFile);
        offer.setOfferImage(image);

        offerRepository.save(offer);
    }


    @Override
    public OfferDto findById(Long id) {
        Offer offer = offerRepository.findById(id).orElse(null);
        OfferDto offerDto = modelMapper.map(offer, OfferDto.class);
        offerDto.setUrl(offer.getOfferImage().getUrl());
        return offerDto;
    }

    @Override
    public AllOffersDto getAllOffersByCountry(String country) {
        List<Offer> allOffers = offerRepository.findByDestination_Country(country);

        List<OfferDto> offers = new ArrayList<>();

        for(Offer offer : allOffers) {
            OfferDto offerDto = modelMapper.map(offer, OfferDto.class);
            offerDto.setUrl(offer.getOfferImage().getUrl());
            offers.add(offerDto);
        }

        return new AllOffersDto(offers);
    }
}
