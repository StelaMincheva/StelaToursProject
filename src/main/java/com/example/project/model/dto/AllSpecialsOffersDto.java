package com.example.project.model.dto;

import java.util.List;

public class AllSpecialsOffersDto {

    private List<SpecialOfferDto> specialOffers;

    public AllSpecialsOffersDto(List<SpecialOfferDto> specialOffers) {
        this.specialOffers = specialOffers;
    }

    public List<SpecialOfferDto> getSpecialOffers() {
        return specialOffers;
    }

    public void setSpecialOffers(List<SpecialOfferDto> specialOffers) {
        this.specialOffers = specialOffers;
    }
}
