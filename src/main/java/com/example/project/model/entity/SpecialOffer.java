package com.example.project.model.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "special_offers")
public class SpecialOffer extends BaseEntity {

    @Length(min = 3, max = 70)
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToOne(optional = false)
    private Image titleImage;
    @ManyToOne(optional = false)
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
