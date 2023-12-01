package com.example.project.service.scheduler;

import com.example.project.service.OfferService;
import com.example.project.service.SpecialOfferService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeletePastOffersScheduler {

    private final OfferService offerService;
    private final SpecialOfferService specialOfferService;

    public DeletePastOffersScheduler(OfferService offerService, SpecialOfferService specialOfferService) {
        this.offerService = offerService;
        this.specialOfferService = specialOfferService;
    }
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteOffers() {
        offerService.deletePastOffers();
        specialOfferService.deletePastSpecialOffers();
    }
}
