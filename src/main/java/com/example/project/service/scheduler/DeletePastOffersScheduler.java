package com.example.project.service.scheduler;

import com.example.project.service.OfferService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeletePastOffersScheduler {

    private final OfferService offerService;

    public DeletePastOffersScheduler(OfferService offerService) {
        this.offerService = offerService;
    }
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteOffers() {
        offerService.deletePastOffers();
    }
}
