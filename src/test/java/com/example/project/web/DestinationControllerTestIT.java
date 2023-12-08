package com.example.project.web;

import com.example.project.model.dto.DestinationAddDto;
import com.example.project.model.dto.DestinationDto;
import com.example.project.model.entity.Image;
import com.example.project.service.DestinationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DestinationControllerTestIT {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DestinationService destinationServiceToTest;

    @Test
    void testViewDestinations() throws Exception {

        List<DestinationDto> destinations = new ArrayList<>();

        DestinationDto destination1 = new DestinationDto();
        destination1.setId(1L);
        destination1.setCountry("test1");
        destination1.setUrl("url1");

        DestinationDto destination2 = new DestinationDto();
        destination2.setId(2L);
        destination2.setCountry("test2");
        destination2.setUrl("url2");

        destinations.add(destination1);
        destinations.add(destination2);

        mockMvc
                .perform(get("/destinations"))
                .andExpect(status().isOk())
                .andExpect(view().name("destinations"))
                .andExpect(model().attributeExists("viewDestinations"));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void testAddDestinationView() throws Exception {
        mockMvc
                .perform(get("/destination-add"))
                .andExpect(status().isOk())
                .andExpect(view().name("destination-add"));
    }





}
