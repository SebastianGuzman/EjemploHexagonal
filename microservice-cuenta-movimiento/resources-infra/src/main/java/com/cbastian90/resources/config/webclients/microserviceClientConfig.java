package com.cbastian90.resources.config.webclients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class microserviceClientConfig {

    @Value("${clients.persona-cliente.host}")
    private String webClientCustomer;

    @Bean
    public WebClient getPersonaCliente(){
        return WebClient.create(webClientCustomer);
    }


}
