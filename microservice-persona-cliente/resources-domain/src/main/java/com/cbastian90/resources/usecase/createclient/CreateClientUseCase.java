package com.cbastian90.resources.usecase.createclient;

import com.cbastian90.resources.kernel.command.createperson.CreateClientCommand;
import com.cbastian90.resources.kernel.domain.createclient.CreateClientInformation;
import com.cbastian90.resources.kernel.domain.createclient.CreateClientPayload;
import com.cbastian90.resources.kernel.domain.util.HeaderObjectInformationErrorResponse;
import com.cbastian90.resources.kernel.domain.util.HeaderObjectInformationResponse;
import com.cbastian90.resources.kernel.domain.util.HttpStatus;
import com.cbastian90.resources.kernel.domain.util.MessageObjectInformationResponse;
import com.cbastian90.resources.kernel.domain.util.models.Client;
import com.cbastian90.resources.kernel.exception.error.UseCaseErrorResponse;
import com.cbastian90.resources.kernel.exception.error.UseCaseErrorResponseError;
import com.cbastian90.resources.ports.database.microservicesdb.client.ClientPort;
import com.cbastian90.resources.usecase.UseCase;
import com.cbastian90.resources.usecase.service.time.TimeManagerService;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;

@AllArgsConstructor
@Slf4j
public class CreateClientUseCase implements UseCase<CreateClientCommand, Either<UseCaseErrorResponse, CreateClientInformation>> {

    private final ClientPort clientPort;

    @Override
    public Either<UseCaseErrorResponse, CreateClientInformation> execute(CreateClientCommand command) {
        Either<Throwable, CreateClientInformation> response =
                Try.of( () -> {

                    // Do something
                    Client client = clientPort.createClient(
                                                            command.getPassword(),
                                                            command.getEstado(),
                                                            command.getName(),
                                                            command.getGender(),
                                                            command.getIdentification(),
                                                            command.getAge(),
                                                            command.getPhone(),
                                                            command.getAddress()
                    ).block(Duration.ofMillis(1000));



                    return buildSuccess(client, HttpStatus.ACCEPTED, command, "Client created successfully");
                }).toEither();
        return response.isRight()?Either.right(response.get()):Either.left(buildErrorResponse(response.getLeft().getMessage() ));
    }

    private CreateClientInformation buildSuccess(Client client,HttpStatus httpStatus, CreateClientCommand command, String messagePayload) {
        return new CreateClientInformation(
                HeaderObjectInformationResponse
                        .builder()
                        .messageUuid(command.getMessageUid())
                        .httpStatusCode(httpStatus.value())
                        .httpStatusDesc(httpStatus.name())
                        .requestDatetime(new TimeManagerService().getInstantIsoFormat())
                        .build(),
                MessageObjectInformationResponse
                        .builder()
                        .responseCode(200)
                        .responseMessage("OK")
                        .responseDetail(messagePayload)
                        .build(),
                CreateClientPayload
                        .builder()
                        .person(client.getPerson())
                        .clientId(client.getClientId())
                        .estado(client.getEstado())
                        .password("*******")
                        .build()
        );
    }

    private UseCaseErrorResponse buildErrorResponse(String message){//String message
        log.error("CreateClientUseCase:: {}",message);
        return UseCaseErrorResponse
                .builder()
                .errors(
                        List.of(UseCaseErrorResponseError
                                .builder()
                                .errorCode("99")
                                .errorDetail(message)
                                .build()
                        )
                )
                .messageResponse(
                        MessageObjectInformationResponse
                                .builder()
                                .responseMessage("Error en servidor, por favor intente mas tarde")
                                .build()
                )
                .headers(
                        HeaderObjectInformationErrorResponse
                                .builder()
                                .httpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .htttpStatusDesc(HttpStatus.INTERNAL_SERVER_ERROR.name())
                                .build())
                .build();

    }
}
