package com.example.project.service.impl;

import com.example.project.model.dto.AllOffersDto;
import com.example.project.model.dto.OfferDto;
import com.example.project.model.entity.Destination;
import com.example.project.model.entity.Image;
import com.example.project.model.entity.Offer;
import com.example.project.repository.DestinationRepository;
import com.example.project.repository.OfferRepository;
import com.example.project.service.ImageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OfferServiceImplTest {

    private OfferServiceImpl offerServiceToTest;
    @Mock
    private OfferRepository mockOfferRepository;
    @Mock
    private ModelMapper mockModelMapper;
    @Mock
    private ImageService mockImageService;
    @Mock
    private DestinationRepository mockDestinationRepository;

    @BeforeEach
    void setUp() {
        offerServiceToTest = new OfferServiceImpl(mockOfferRepository, mockModelMapper,
                mockImageService, mockDestinationRepository);
    }

    @Test
    void testFindById() {
        Image image = new Image();
        image.setId(1L);
        image.setUrl("testUrl");

        Offer offer = new Offer();
        offer.setId(1L);
        offer.setOfferImage(image);

        OfferDto offerDto = new OfferDto();
        offerDto.setId(1L);
        offerDto.setUrl("testUrl");

        when(mockOfferRepository.findById(anyLong()))
                .thenReturn(Optional.of(offer));

        when(mockModelMapper.map(offer, OfferDto.class))
                .thenReturn(offerDto);

        OfferDto result =offerServiceToTest.findById(1L);

        Assertions.assertEquals(offerDto, result);

    }

    @Test
    void testDeletePastOffers() {
        LocalDate today = LocalDate.now();
        List<Offer> offers = new ArrayList<>();

        Offer pastOffer = new Offer();
        pastOffer.setId(1L);
        pastOffer.setTitle("test1");
        pastOffer.setDate(today.minusDays(1));

        Offer furureOffer = new Offer();
        furureOffer.setId(2L);
        furureOffer.setTitle("test2");
        furureOffer.setDate(today.plusDays(1));

        Offer pastOffer1 = new Offer();
        pastOffer1.setId(3L);
        pastOffer1.setTitle("test3");
        pastOffer1.setDate(today.minusDays(5));

        offers.add(pastOffer);
        offers.add(furureOffer);
        offers.add(pastOffer1);






    }





}
