package com.example.project.service.impl;

import com.example.project.model.entity.Image;
import com.example.project.repository.ImageRepository;
import com.example.project.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class ImageServiceImpl implements ImageService {

    private static final String IMAGES_SAVE_PATH = "src/main/resources/static/images/";

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    @Override
    public Image create(MultipartFile imageFile, String path) {
        try {
            File file = new File(IMAGES_SAVE_PATH + path);
            file.getParentFile().mkdirs();
            file.createNewFile();

            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(imageFile.getBytes());

            Image image = new Image();
            image.setUrl(path);

            imageRepository.save(image);
            return image;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getPath(String folderName, String fileName, MultipartFile image) {
        String[] imageName = image.getOriginalFilename().split("\\.");
        String extension = imageName[imageName.length - 1];
        String pathPattern = "%s%s.%s";
        return String.format(pathPattern, folderName, fileName, extension);
    }
}
