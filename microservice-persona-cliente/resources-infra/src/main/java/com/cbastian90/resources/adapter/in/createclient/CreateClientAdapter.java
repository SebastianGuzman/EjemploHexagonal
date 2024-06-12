package com.cbastian90.resources.adapter.in.createclient;

import com.cbastian90.resources.adapter.in.createclient.dto.CreateClientRequest;
import com.cbastian90.resources.adapter.in.util.GenericResponse;
import com.cbastian90.resources.handler.createclient.CreateClientHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotEmpty;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/v1/api-rest")
@RequiredArgsConstructor
@Validated
@EnableCaching
@Slf4j
public class CreateClientAdapter {
    private final CreateClientHandler handler;

    @PostMapping(value = "/clientes")
    public Mono<ResponseEntity<GenericResponse>> createClient(
            @RequestHeader(name = "Authorization") @NotEmpty(message = "Authorization cannot be empty") String authorization,
            @RequestHeader(name = "message-uuid", required = false) String messageUuid,
            @RequestBody CreateClientRequest createClientRequest ) {

                return handler.execute(authorization, messageUuid, createClientRequest);
    }
}
