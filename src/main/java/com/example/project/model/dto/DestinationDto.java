package com.example.project.model.dto;

import com.example.project.model.entity.Destination;

import java.util.ArrayList;
import java.util.List;

public class DestinationDto {

    private Long id;
    private String country;
    private String url;
    private List<OfferDto> offers;

    public DestinationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<OfferDto> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferDto> offers) {
        this.offers = offers;
    }
}
