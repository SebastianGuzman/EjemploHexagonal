package com.cbastian90.resources.adapter.out.webclient.personacliente.webclient;

import com.cbastian90.resources.adapter.out.webclient.personacliente.dto.PersonaClienteDtoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
public class MicroservicePersonaClienteClient {

    private final WebClient webClient;
    private final String URI_MICRO_SERVICE = "/clientes";

    public Mono<PersonaClienteDtoResponse> getPersonaCliente(Long id) {
        log.info("Calling microservice");
        return webClient.get()
                .uri(URI_MICRO_SERVICE + "/" + id)
                .exchange()
                .flatMap(clientResponse -> {
                    HttpStatus httpStatus = clientResponse.statusCode();

                    if (httpStatus.is2xxSuccessful()) {
                        log.info("getAccounts response {}", clientResponse);
                        //TODO: Validar el código
                        try {
                            log.info("{}", new ObjectMapper().writeValueAsString(clientResponse));
                        } catch (Exception e) {
                            log.error("error al convertir el json:{}", e.getMessage());
                        }

                        return clientResponse.
                                bodyToMono(PersonaClienteDtoResponse.class);
                    } else {
                        log.info("getAccounts clientResponse {}", clientResponse);
                        return Mono.error(new RuntimeException("Error, Client Information details"));
                    }
                })
                .doOnSuccess(m -> log.info("Video Base Log, Success: "))
                .doOnError(error -> log.error(error.getMessage()))
                .onErrorResume(Mono::error);

    }

}
