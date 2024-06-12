package com.cbastian90.resources.config;


import com.cbastian90.resources.ports.database.microservicesdb.client.ClientPort;
import com.cbastian90.resources.usecase.createclient.CreateClientUseCase;
import com.cbastian90.resources.usecase.example.ExampleUseCase;
import com.cbastian90.resources.usecase.readClient.ReadClientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {


    @Bean
    public ExampleUseCase getExampleUseCase() {
        return new ExampleUseCase(
        );
    }

    @Bean
    public CreateClientUseCase getCreateClientUseCase(final ClientPort clientPort ) {
        return new CreateClientUseCase(clientPort);
    }

    @Bean
    public ReadClientUseCase getReadClientUseCase(final ClientPort clientPort ) {
        return new ReadClientUseCase(clientPort);
    }

}
