package com.example.project.model.dto;

public class DestinationAddDto {

    private CountryDto country;
    private ImageDto destinationImage;

    public DestinationAddDto() {
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public ImageDto getDestinationImage() {
        return destinationImage;
    }

    public void setDestinationImage(ImageDto destinationImage) {
        this.destinationImage = destinationImage;
    }
}
