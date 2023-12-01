package com.example.project.service;

import com.example.project.model.dto.AllOffersDto;
import com.example.project.model.dto.OfferAddDto;
import com.example.project.model.dto.OfferDto;
import com.example.project.model.entity.Offer;

public interface OfferService {

    void addOffer(OfferAddDto offerAddDto);

    OfferDto findById(Long id);

    AllOffersDto getAllOffersByCountry(String country);

    Offer likeOffer(Long id);

    void deletePastOffers();
}
