package com.example.project.model.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Entity
@Table(name = "special_offers")
public class SpecialOffer extends BaseEntity {

    @Length(min = 3, max = 70)
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToOne(optional = false)
    private Image specialOfferImage;
    @Column(name = "info", columnDefinition = "TEXT", nullable = false)
    private String info;
    @Column(name = "program", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String program;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "description", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String description;
    @ManyToOne(optional = false)
    private SeasonalDestination seasonalDestination;

    public SpecialOffer() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getSpecialOfferImage() {
        return specialOfferImage;
    }

    public void setSpecialOfferImage(Image specialOfferImage) {
        this.specialOfferImage = specialOfferImage;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SeasonalDestination getSeasonalDestination() {
        return seasonalDestination;
    }

    public void setSeasonalDestination(SeasonalDestination seasonalDestination) {
        this.seasonalDestination = seasonalDestination;
    }
}
