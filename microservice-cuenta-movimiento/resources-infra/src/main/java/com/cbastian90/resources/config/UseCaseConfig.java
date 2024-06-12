package com.cbastian90.resources.config;


import com.cbastian90.resources.usecase.example.ExampleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {


    @Bean
    public ExampleUseCase getExampleUseCase() {
        return new ExampleUseCase(
        );
    }


}
