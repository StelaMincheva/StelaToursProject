package com.example.project.model.entity;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "destinations")
public class Destination extends BaseEntity {

    @ManyToOne(optional = false)
    private Country country;
    @ManyToOne(optional = false)
    private Image destinationImage;
    @OneToMany
    private Set<Offer> offers;

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

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
