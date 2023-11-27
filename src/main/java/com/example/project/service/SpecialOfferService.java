package com.example.project.service;

import com.example.project.model.dto.AllSpecialsOffersDto;
import com.example.project.model.dto.OfferDto;
import com.example.project.model.dto.SpecialOfferAddDto;
import com.example.project.model.dto.SpecialOfferDto;

public interface SpecialOfferService {

    void addSpecialOffer(SpecialOfferAddDto specialOfferAddDto);
    SpecialOfferDto findById(Long id);
    AllSpecialsOffersDto getAllSpecialOffersByTitle(String title);
}
