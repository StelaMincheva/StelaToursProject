package com.example.project.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "seasonal_offers")
public class SeasonalOffer extends BaseEntity {

    @Column(name = "offer_title", nullable = false)
    private String offerTitle;
    @ManyToOne
    private Image image;
    @OneToMany
    private Set<SpecialOffer> specialOffers;

    public SeasonalOffer() {
    }

    public String getOfferTitle() {
        return offerTitle;
    }

    public void setOfferTitle(String offerTitle) {
        this.offerTitle = offerTitle;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Set<SpecialOffer> getSpecialOffers() {
        return specialOffers;
    }

    public void setSpecialOffers(Set<SpecialOffer> specialOffers) {
        this.specialOffers = specialOffers;
    }
}
