package com.example.project.service.impl;

import com.example.project.repository.ImageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

@ExtendWith(MockitoExtension.class)
public class ImageServiceImplTest {

    ImageServiceImpl imageServiceToTest;

    @Mock
    ImageRepository mockImageRepository;

    @BeforeEach
    void setUp() {
        imageServiceToTest = new ImageServiceImpl(mockImageRepository);
    }

    @Test
    void testGetPath() {
        String folderName = "images/";
        String fileName = "example.jpg";
        MockMultipartFile image = new MockMultipartFile("image", "example.jpg",
                "image/jpeg", new byte[0]);

        String result = imageServiceToTest.getPath(folderName, fileName, image);

        String testPath = "images/example.jpg";
        Assertions.assertEquals(testPath, result);
    }






}
