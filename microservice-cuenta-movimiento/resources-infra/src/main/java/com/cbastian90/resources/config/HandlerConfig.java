package com.cbastian90.resources.config;


import com.cbastian90.resources.handler.example.ExampleHandler;
import com.cbastian90.resources.usecase.example.ExampleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfig {


    @Bean
    public ExampleHandler getAccountListInformationHandler(final ExampleUseCase useCase) {
        return new ExampleHandler(useCase);
    }


}
