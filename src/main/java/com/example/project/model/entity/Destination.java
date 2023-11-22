package com.example.project.model.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "destinations")
public class Destination extends BaseEntity {

    @ManyToOne(optional = false)
    private Country country;
    @ManyToOne(optional = false)
    private Image destinationImage;
    @OneToMany
    private List<Offer> offers;

    public Destination() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Image getDestinationImage() {
        return destinationImage;
    }

    public void setDestinationImage(Image destinationImage) {
        this.destinationImage = destinationImage;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
