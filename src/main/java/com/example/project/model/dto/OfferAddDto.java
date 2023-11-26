package com.example.project.model.dto;

import com.example.project.model.entity.Destination;
import com.example.project.validation.ImageAnnotation;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class OfferAddDto {

    @Size(min = 3, max = 70, message = "Title length must be between 3 and 70 characters!")
    @NotNull
    private String title;
    @ImageAnnotation(contentTypes = {"image/jpeg", "image/png"})
    private MultipartFile offerImage;
    @NotBlank(message = "Enter an info!")
    private String info;
    @NotBlank(message = "Enter a program!")
    private String program;
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater then zero!")
    @NotNull(message = "Enter a price!")
    private BigDecimal price;
    @NotBlank(message = "Enter a title!")
    private String priceIncludesTitle;
    @NotBlank(message = "Enter an info!")
    private String priceIncludesInfo;
    @NotBlank(message = "Enter a title!")
    private String priceNotIncludesTitle;
    @NotBlank(message = "Enter an info!")
    private String priceNotIncludesInfo;
    @NotBlank(message = "Enter a title!")
    private String requiredDocumentsTitle;
    @NotBlank(message = "Enter an info!")
    private String requiredDocumentsInfo;
    @NotBlank(message = "Enter a title!")
    private String methodOfPaymentTitle;
    @NotBlank(message = "Enter an info!")
    private String methodOfPaymentInfo;
    @NotBlank(message = "Enter a title!")
    private String minNumberOfTouristsTitle;
    @NotBlank(message = "Enter an info!")
    private String minNumberOfTouristsInfo;
    @NotNull(message = "Select a destination!")
    private Destination destination;

    public OfferAddDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(MultipartFile offerImage) {
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
}
