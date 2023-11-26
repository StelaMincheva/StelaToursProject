package com.example.project.model.dto;

import java.util.List;

public class AllOffersDto {

    private List<OfferDto> offers;

    public AllOffersDto(List<OfferDto> offers) {
        this.offers = offers;
    }

    public List<OfferDto> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferDto> offers) {
        this.offers = offers;
    }
}
