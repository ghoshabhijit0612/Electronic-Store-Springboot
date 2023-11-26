package com.Electronic.Store.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
public class modelmapper {
    @Bean
    public ModelMapper modelmapperr(){
        return new ModelMapper();
    }

}
