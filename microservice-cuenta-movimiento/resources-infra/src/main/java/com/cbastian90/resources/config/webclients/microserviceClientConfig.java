package com.cbastian90.resources.config.webclients;

import com.cbastian90.resources.adapter.out.webclient.personacliente.webclient.MicroservicePersonaClienteClient;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean
    public MicroservicePersonaClienteClient getMicroservicePersonaClienteClient(@Qualifier("getPersonaCliente") WebClient webClient){
        return new MicroservicePersonaClienteClient(webClient);
    }

}
