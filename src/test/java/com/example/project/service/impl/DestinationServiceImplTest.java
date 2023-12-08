package com.example.project.service.impl;

import com.example.project.model.entity.Destination;
import com.example.project.model.entity.Offer;
import com.example.project.repository.DestinationRepository;
import com.example.project.repository.OfferRepository;
import com.example.project.service.ImageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DestinationServiceImplTest {

    private DestinationServiceImpl destinationServiceToTest;
    @Mock
    private DestinationRepository mockDestinationRepository;
    @Mock
    private ImageService mockImageService;
    @Mock
    private ModelMapper mockModelMapper;
    @Mock
    private OfferRepository mockOfferRepository;

    @BeforeEach
    void setUp() {
        destinationServiceToTest = new DestinationServiceImpl(mockDestinationRepository, mockImageService,
                mockModelMapper, mockOfferRepository);
    }


    @Test
    void testDeleteDestination() {
        Destination testDestination = new Destination();
        testDestination.setId(1L);
        testDestination.setCountry("country");

        Offer testOffer = new Offer();
        testOffer.setId(1L);
        testOffer.setDestination(testDestination);

        List<Offer> testOffers = Arrays.asList(testOffer);

        when(mockDestinationRepository.findById(1L))
                .thenReturn(Optional.of(testDestination));

        when(mockOfferRepository.findByDestination_Country("country"))
                .thenReturn(testOffers);

        destinationServiceToTest.deleteDestination(1L);
    }




}
