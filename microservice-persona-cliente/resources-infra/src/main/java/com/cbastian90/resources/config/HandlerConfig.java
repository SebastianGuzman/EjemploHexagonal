package com.cbastian90.resources.config;


import com.cbastian90.resources.handler.createclient.CreateClientHandler;
import com.cbastian90.resources.handler.example.ExampleHandler;
import com.cbastian90.resources.handler.readClient.ReadClientHandler;
import com.cbastian90.resources.usecase.createclient.CreateClientUseCase;
import com.cbastian90.resources.usecase.example.ExampleUseCase;
import com.cbastian90.resources.usecase.readClient.ReadClientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfig {


    @Bean
    public ExampleHandler getAccountListInformationHandler(final ExampleUseCase useCase) {
        return new ExampleHandler(useCase);
    }

    @Bean
    public CreateClientHandler getCreateClientHandler(final CreateClientUseCase useCase) {
        return new CreateClientHandler(useCase);
    }

    @Bean
    public ReadClientHandler getReadClientHandler(final ReadClientUseCase useCase) {
        return new ReadClientHandler(useCase);
    }

}
