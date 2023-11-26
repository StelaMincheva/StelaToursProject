package com.example.project.model.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "seasonal_destinations")
public class SeasonalDestination extends BaseEntity {
    @Column(name = "title", nullable = false, unique = true)
    private String title;
    @ManyToOne(optional = false)
    private Image seasonalImage;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seasonalDestination")
    private List<SpecialOffer> specialOffers;

    public SeasonalDestination() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getSeasonalImage() {
        return seasonalImage;
    }

    public void setSeasonalImage(Image seasonalImage) {
        this.seasonalImage = seasonalImage;
    }

    public List<SpecialOffer> getSpecialOffers() {
        return specialOffers;
    }

    public void setSpecialOffers(List<SpecialOffer> specialOffers) {
        this.specialOffers = specialOffers;
    }
}
