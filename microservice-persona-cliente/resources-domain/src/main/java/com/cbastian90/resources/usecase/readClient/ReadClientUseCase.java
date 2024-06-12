package com.cbastian90.resources.usecase.readClient;

import com.cbastian90.resources.kernel.command.readClient.ReadClientCommand;
import com.cbastian90.resources.kernel.domain.readClient.ReadClientInformation;
import com.cbastian90.resources.kernel.domain.readClient.ReadClientPayload;
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
public class ReadClientUseCase implements UseCase<ReadClientCommand, Either<UseCaseErrorResponse, ReadClientInformation>> {
    private final ClientPort clientPort;

    @Override
    public Either<UseCaseErrorResponse, ReadClientInformation> execute(ReadClientCommand command) {
        Either<Throwable, ReadClientInformation> response =
                Try.of( () -> {
                    // Do something
                    Client client = clientPort.readClient(
                            command.getClientId()
                    ).block(Duration.ofMillis(1000));

                    return buildSuccess(client, HttpStatus.OK, command, "Client retrived successfully");
                }).toEither();
        return response.isRight()?Either.right(response.get()):Either.left(buildErrorResponse(response.getLeft().getMessage() ));
    }

    private ReadClientInformation buildSuccess(Client client, HttpStatus httpStatus, ReadClientCommand command, String messagePayload) {
        return new ReadClientInformation(
                HeaderObjectInformationResponse
                        .builder()
                        .messageUuid(command.getMessageUid())
                        .httpStatusCode(httpStatus.value())
                        .httpStatusDesc(httpStatus.name())
                        .requestDatetime(new TimeManagerService().getInstantIsoFormat())
                        .build(),
                MessageObjectInformationResponse
                        .builder()
                        .responseCode(httpStatus.value())
                        .responseMessage("OK")
                        .responseDetail(messagePayload)
                        .build(),
                ReadClientPayload
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
