package com.example.project.web;

import com.example.project.model.dto.OfferAddDto;
import com.example.project.model.dto.OfferDto;
import com.example.project.model.entity.Destination;
import com.example.project.model.entity.Image;
import com.example.project.model.entity.Offer;
import com.example.project.repository.DestinationRepository;
import com.example.project.repository.ImageRepository;
import com.example.project.repository.OfferRepository;
import com.example.project.service.OfferService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OfferControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OfferService offerServiceToTest;

    @Autowired
    private DestinationRepository destinationRepositoryToTest;

    @Autowired
    private OfferRepository offerRepositoryToTest;
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void testAddOfferView() throws Exception {
        List<Destination> destinations = new ArrayList<>();

        Destination destination1 = new Destination();
        destination1.setCountry("test1");

        Destination destination2 = new Destination();
        destination2.setCountry("test2");

        destinations.add(destination1);
        destinations.add(destination2);

        mockMvc
                .perform(get("/offer-add"))
                .andExpect(status().isOk())
                .andExpect(view().name("/offer-add"))
                .andExpect(model().attributeExists("destinations"));
    }

    @Test
    @WithMockUser(username = "test@test.bg", roles = {"USER"})
    void testOfferDetailsPage() throws Exception {

        Image image = new Image();
        image.setUrl("url");
        imageRepository.save(image);
        Destination destination = new Destination();
        destination.setCountry("test");
        destination.setDestinationImage(image);
        destinationRepositoryToTest.save(destination);

        Offer offer = new Offer();
        offer.setTitle("test");
        offer.setOfferImage(image);
        offer.setInfo("test");
        offer.setProgram("test");
        offer.setPrice(BigDecimal.valueOf(900));
        offer.setPriceIncludes("test. test");
        offer.setPriceNotIncludes("test. test");
        offer.setRequiredDocuments("test");
        offer.setMethodOfPayment("test");
        offer.setMinNumberOfTourists("test");
        offer.setTypeOfTransport("test");
        offer.setDuration("test");
        offer.setDate(LocalDate.parse("2023-12-26"));
        offer.setDestination(destination);

        offerRepositoryToTest.save(offer);


        mockMvc.perform(get("/offer-details/{id}", offer.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("offer-details"));
    }
}
