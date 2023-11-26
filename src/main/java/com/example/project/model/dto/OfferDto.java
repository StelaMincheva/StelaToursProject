package com.example.project.model.dto;

import com.example.project.model.entity.Offer;

import java.math.BigDecimal;

public class OfferDto {

    private Long id;
    private String title;
    private String url;
    private String info;
    private String program;
    private BigDecimal price;
    private String priceIncludesTitle;
    private String priceIncludesInfo;
    private String priceNotIncludesTitle;
    private String priceNotIncludesInfo;
    private String requiredDocumentsTitle;
    private String requiredDocumentsInfo;
    private String methodOfPaymentTitle;
    private String methodOfPaymentInfo;
    private String minNumberOfTouristsTitle;
    private String minNumberOfTouristsInfo;
    private Long destinationId;

    public OfferDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }
}
