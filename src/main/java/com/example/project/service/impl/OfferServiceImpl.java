package com.example.project.service.impl;

import com.example.project.model.dto.OfferAddDto;
import com.example.project.model.entity.Image;
import com.example.project.model.entity.Offer;
import com.example.project.repository.OfferRepository;
import com.example.project.service.ImageService;
import com.example.project.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String FOLDER_PATH = "offerImages/";

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ImageService imageService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ImageService imageService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.imageService = imageService;
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
}
