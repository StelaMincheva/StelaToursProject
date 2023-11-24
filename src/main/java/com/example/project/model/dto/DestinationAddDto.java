package com.example.project.model.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class DestinationAddDto {

    @NotNull(message = "Enter a country!")
    private String countryName;

    @NotNull(message = "Enter an image!")
    private String url;

    public DestinationAddDto() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
