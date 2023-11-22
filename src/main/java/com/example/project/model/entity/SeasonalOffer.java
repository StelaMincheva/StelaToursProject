package com.example.project.model.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;


@Entity
@Table(name = "seasonal_offers")
public class SeasonalOffer extends BaseEntity {

    @Length(min = 3, max = 70)
    @Column(name = "offer_title", nullable = false)
    private String offerTitle;
    @ManyToOne
    private Image image;
    @OneToMany
    private List<SpecialOffer> specialOffers;

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

    public List<SpecialOffer> getSpecialOffers() {
        return specialOffers;
    }

    public void setSpecialOffers(List<SpecialOffer> specialOffers) {
        this.specialOffers = specialOffers;
    }
}
