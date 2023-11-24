package com.example.project.model.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class DestinationAddDto {

    @NotNull(message = "Enter a country!")
    private String country;

    @NotNull(message = "Enter an image!")
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
