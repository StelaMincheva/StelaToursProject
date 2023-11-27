package com.example.project.model.dto;

import java.util.List;

public class SeasonalDestinationDto {

    private Long id;
    private String title;
    private String url;
    private List<SpecialOfferDto> specialOffers;

    public SeasonalDestinationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<SpecialOfferDto> getSpecialOffers() {
        return specialOffers;
    }

    public void setSpecialOffers(List<SpecialOfferDto> specialOffers) {
        this.specialOffers = specialOffers;
    }
}
