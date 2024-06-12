package com.cbastian90.resources.handler.readClient;

import com.cbastian90.resources.adapter.in.error.mapper.ErrorResponseMapper;
import com.cbastian90.resources.adapter.in.util.GenericResponse;
import com.cbastian90.resources.handler.ResponseBuilder;
import com.cbastian90.resources.handler.error.ErrorHandler;
import com.cbastian90.resources.handler.readClient.mapper.ReadClientMapper;
import com.cbastian90.resources.kernel.command.readClient.ReadClientCommand;
import com.cbastian90.resources.usecase.readClient.ReadClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ReadClientHandler {
    private final ReadClientUseCase useCase;

    public Mono<ResponseEntity<GenericResponse>> execute(String authorization, String messageUid, Long clientId){
        return Mono.just(
                        useCase.execute(buildCommand(authorization, messageUid, clientId))
                                .fold(
                                        ErrorResponseMapper::useCaseErrorToResponse,
                                        ReadClientMapper::informationToResponse
                                )
                )
                .map(genericResponse -> new ResponseBuilder().mapResponseBuilder(genericResponse))
                .switchIfEmpty(Mono.just(ResponseEntity.noContent().build()))
                .onErrorResume(ErrorHandler::handlerError);
    }

    private ReadClientCommand buildCommand(String authorization, String messageUid, Long clientId){
        return ReadClientMapper.requestToCommand(authorization, messageUid, clientId);
    }


}
