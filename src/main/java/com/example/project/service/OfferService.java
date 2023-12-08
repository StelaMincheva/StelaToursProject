package com.example.project.service;

import com.example.project.model.dto.AllOffersDto;
import com.example.project.model.dto.OfferAddDto;
import com.example.project.model.dto.OfferDto;

public interface OfferService {

    void addOffer(OfferAddDto offerAddDto);

    OfferDto findById(Long id);

    AllOffersDto getAllOffersByCountry(String country);

    void deletePastOffers();
}
