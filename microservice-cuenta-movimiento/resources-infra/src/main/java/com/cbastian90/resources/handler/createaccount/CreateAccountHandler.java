package com.cbastian90.resources.handler.createaccount;

import com.cbastian90.resources.adapter.in.createaccount.dto.CreateAccountRequest;
import com.cbastian90.resources.adapter.in.error.mapper.ErrorResponseMapper;
import com.cbastian90.resources.adapter.in.util.GenericResponse;
import com.cbastian90.resources.handler.ResponseBuilder;
import com.cbastian90.resources.handler.createaccount.mapper.CreateAccountMapper;
import com.cbastian90.resources.handler.error.ErrorHandler;
import com.cbastian90.resources.kernel.command.createaccount.CreateAccountCommand;
import com.cbastian90.resources.usecase.createaccount.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateAccountHandler {
    private final CreateAccountUseCase useCase;

    public Mono<ResponseEntity<GenericResponse>> execute(String authorization, String messageUid, CreateAccountRequest createClientRequest){
        return Mono.just(
                        useCase.execute(buildCommand(authorization, messageUid, createClientRequest))
                                .fold(
                                        ErrorResponseMapper::useCaseErrorToResponse,
                                        CreateAccountMapper::informationToResponse
                                )
                )
                .map(genericResponse -> new ResponseBuilder().mapResponseBuilder(genericResponse))
                .switchIfEmpty(Mono.just(ResponseEntity.noContent().build()))
                .onErrorResume(ErrorHandler::handlerError);
    }

    private CreateAccountCommand buildCommand(String authorization, String messageUid, CreateAccountRequest createClientRequest){
        return CreateAccountMapper.requestToCommand(authorization, messageUid, createClientRequest);
    }

}
