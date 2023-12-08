package com.example.project.config;

import com.example.project.model.dto.OfferDto;
import com.example.project.model.entity.Image;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper
                .createTypeMap(Image.class, OfferDto.class)
                .addMappings(mapper -> mapper
                        .map(Image::getUrl, OfferDto::setUrl));

        return modelMapper;
    }

}
