package com.example.project.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

       //modelMapper
                //.createTypeMap(Image.class, DestinationAddDto.class)
                //.addMappings(mapper -> mapper
                        //.map(Image::getUrl, DestinationAddDto::setUrl));

        //modelMapper
                //.createTypeMap(Country.class, DestinationAddDto.class)
                //.addMappings(mapper -> mapper
                        //.map(Country::getCountryName, DestinationAddDto::setCountry));

        return modelMapper;
    }

}
