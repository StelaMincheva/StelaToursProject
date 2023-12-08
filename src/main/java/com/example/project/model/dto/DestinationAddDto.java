package com.example.project.model.dto;

import com.example.project.validation.ImageAnnotation;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class DestinationAddDto {

    @NotBlank(message = "Enter a country!")
    private String country;

    @ImageAnnotation(contentTypes = {"image/jpeg", "image/png"})
    private MultipartFile destinationImage;

    public DestinationAddDto() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public MultipartFile getDestinationImage() {
        return destinationImage;
    }

    public void setDestinationImage(MultipartFile destinationImage) {
        this.destinationImage = destinationImage;
    }
}
