package com.example.project.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "destinations")
public class Destination extends BaseEntity {

   @Column(name = "country", nullable = false, unique = true)
    private String country;
    @ManyToOne(optional = false)
    private Image destinationImage;
    @OneToMany(mappedBy = "destination")
    private List<Offer> offers;

    public Destination() {
    }

    public String  getCountry() {
        return country;
    }

    public void setCountry(String country) {
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
