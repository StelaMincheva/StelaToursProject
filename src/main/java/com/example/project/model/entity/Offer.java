package com.example.project.model.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Length(min = 3, max = 70)
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToOne
    private Image offerImage;
    @Column(name = "info", columnDefinition = "TEXT", nullable = false)
    private String info;
    @Column(name = "program", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String program;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "price_includes_title", nullable = false)
    private String priceIncludesTitle;
    @Column(name = "price_includes_info", nullable = false)
    private String priceIncludesInfo;
    @Column(name = "price_not_includes_title", nullable = false)
    private String priceNotIncludesTitle;
    @Column(name = "price_not_includes_info", nullable = false)
    private String priceNotIncludesInfo;
    @Column(name = "required_documents_title", nullable = false)
    private String requiredDocumentsTitle;
    @Column(name = "required_documents_info", nullable = false)
    private String requiredDocumentsInfo;
    @Column(name = "method_of_payment_title", nullable = false)
    private String methodOfPaymentTitle;
    @Column(name = "method_of_payment_info", nullable = false)
    private String methodOfPaymentInfo;
    @Column(name = "min_number_of_tourists_title", nullable = false)
    private String minNumberOfTouristsTitle;
    @Column(name = "min_number_of_tourists_info", nullable = false)
    private String minNumberOfTouristsInfo;
    @ManyToOne(optional = false)
    private Destination destination;
    @OneToMany(mappedBy = "offer")
    private List<Reservation> reservations;

    public Offer() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(Image offerImage) {
        this.offerImage = offerImage;
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

    public String getPriceIncludesTitle() {
        return priceIncludesTitle;
    }

    public void setPriceIncludesTitle(String priceIncludesTitle) {
        this.priceIncludesTitle = priceIncludesTitle;
    }

    public String getPriceIncludesInfo() {
        return priceIncludesInfo;
    }

    public void setPriceIncludesInfo(String priceIncludesInfo) {
        this.priceIncludesInfo = priceIncludesInfo;
    }

    public String getPriceNotIncludesTitle() {
        return priceNotIncludesTitle;
    }

    public void setPriceNotIncludesTitle(String priceNotIncludesTitle) {
        this.priceNotIncludesTitle = priceNotIncludesTitle;
    }

    public String getPriceNotIncludesInfo() {
        return priceNotIncludesInfo;
    }

    public void setPriceNotIncludesInfo(String priceNotIncludesInfo) {
        this.priceNotIncludesInfo = priceNotIncludesInfo;
    }

    public String getRequiredDocumentsTitle() {
        return requiredDocumentsTitle;
    }

    public void setRequiredDocumentsTitle(String requiredDocumentsTitle) {
        this.requiredDocumentsTitle = requiredDocumentsTitle;
    }

    public String getRequiredDocumentsInfo() {
        return requiredDocumentsInfo;
    }

    public void setRequiredDocumentsInfo(String requiredDocumentsInfo) {
        this.requiredDocumentsInfo = requiredDocumentsInfo;
    }

    public String getMethodOfPaymentTitle() {
        return methodOfPaymentTitle;
    }

    public void setMethodOfPaymentTitle(String methodOfPaymentTitle) {
        this.methodOfPaymentTitle = methodOfPaymentTitle;
    }

    public String getMethodOfPaymentInfo() {
        return methodOfPaymentInfo;
    }

    public void setMethodOfPaymentInfo(String methodOfPaymentInfo) {
        this.methodOfPaymentInfo = methodOfPaymentInfo;
    }

    public String getMinNumberOfTouristsTitle() {
        return minNumberOfTouristsTitle;
    }

    public void setMinNumberOfTouristsTitle(String minNumberOfTouristsTitle) {
        this.minNumberOfTouristsTitle = minNumberOfTouristsTitle;
    }

    public String getMinNumberOfTouristsInfo() {
        return minNumberOfTouristsInfo;
    }

    public void setMinNumberOfTouristsInfo(String minNumberOfTouristsInfo) {
        this.minNumberOfTouristsInfo = minNumberOfTouristsInfo;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
