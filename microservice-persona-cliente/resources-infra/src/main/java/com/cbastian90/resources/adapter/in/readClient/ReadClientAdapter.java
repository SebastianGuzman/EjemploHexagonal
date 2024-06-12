package com.cbastian90.resources.adapter.in.readClient;

import com.cbastian90.resources.adapter.in.util.GenericResponse;
import com.cbastian90.resources.handler.readClient.ReadClientHandler;
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
public class ReadClientAdapter {
    private final ReadClientHandler handler;

    @GetMapping(value = "/clientes/{id}")
    public Mono<ResponseEntity<GenericResponse>> readClient(
            @RequestHeader(name = "Authorization") @NotEmpty(message = "Authorization cannot be empty") String authorization,
            @RequestHeader(name = "message-uuid", required = false) String messageUuid,
            @PathVariable(name = "id") Long id
    ) {
        return handler.execute(authorization, messageUuid, id);
    }
}
