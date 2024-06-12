package com.cbastian90.resources.adapter.out.webclient.personacliente;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@AllArgsConstructor
public class microserviceClient {

    private final WebClient webClient;
    private final String URI_MICRO_SERVICE = "/clientes";
}
