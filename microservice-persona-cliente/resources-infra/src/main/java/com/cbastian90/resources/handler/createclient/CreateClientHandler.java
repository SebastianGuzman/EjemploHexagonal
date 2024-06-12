package com.cbastian90.resources.handler.createclient;

import com.cbastian90.resources.adapter.in.createclient.dto.CreateClientRequest;
import com.cbastian90.resources.adapter.in.error.mapper.ErrorResponseMapper;
import com.cbastian90.resources.adapter.in.util.GenericResponse;
import com.cbastian90.resources.handler.ResponseBuilder;
import com.cbastian90.resources.handler.createclient.mapper.CreateClientMapper;
import com.cbastian90.resources.handler.error.ErrorHandler;
import com.cbastian90.resources.kernel.command.createperson.CreateClientCommand;
import com.cbastian90.resources.usecase.createclient.CreateClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateClientHandler {

    private final CreateClientUseCase useCase;

    public Mono<ResponseEntity<GenericResponse>> execute(String authorization, String messageUid, CreateClientRequest createClientRequest){
        return Mono.just(
                        useCase.execute(buildCommand(authorization, messageUid, createClientRequest))
                                .fold(
                                        ErrorResponseMapper::useCaseErrorToResponse,
                                        CreateClientMapper::informationToResponse
                                )
                )
                .map(genericResponse -> new ResponseBuilder().mapResponseBuilder(genericResponse))
                .switchIfEmpty(Mono.just(ResponseEntity.noContent().build()))
                .onErrorResume(ErrorHandler::handlerError);
    }

    private CreateClientCommand buildCommand(String authorization, String messageUid, CreateClientRequest createClientRequest){
        return CreateClientMapper.requestToCommand(authorization, messageUid, createClientRequest);
    }

}
