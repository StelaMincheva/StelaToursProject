package com.example.project.model.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "seasonal_destinations")
public class SeasonalDestination extends BaseEntity {
    @Column(name = "title", nullable = false, unique = true)
    private String title;
    @ManyToOne(optional = false)
    private Image seasonalImage;

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
}
