package com.example.project.model.dto;

import jakarta.validation.constraints.NotNull;

public class ImageDto {
    @NotNull
    private String url;

    public ImageDto() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
