package com.example.project.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "special_offers")
public class SpecialOffer extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;
    @ManyToOne
    private Image titleImage;
    @ManyToOne
    private Offer offer;


    public SpecialOffer() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(Image titleImage) {
        this.titleImage = titleImage;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
