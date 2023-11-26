package com.example.project.model.dto;

import com.example.project.validation.ImageAnnotation;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class SeasonalDestinationAddDto {
    @NotBlank(message = "Enter a title!")
    private String title;
    @ImageAnnotation(contentTypes = {"image/jpeg", "image/png"})
    private MultipartFile seasonalImage;

    public SeasonalDestinationAddDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getSeasonalImage() {
        return seasonalImage;
    }

    public void setSeasonalImage(MultipartFile seasonalImage) {
        this.seasonalImage = seasonalImage;
    }
}
