package com.example.project.service;

import com.example.project.model.entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Image create(MultipartFile imageFile, String path);
    String getPath(String folderName, String fileName, MultipartFile image);
}
