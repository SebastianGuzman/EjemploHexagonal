package com.cbastian90.resources.usecase.createaccount;

import com.cbastian90.resources.kernel.command.createaccount.CreateAccountCommand;
import com.cbastian90.resources.kernel.domain.createaccount.CreateAccountInformation;
import com.cbastian90.resources.kernel.domain.createaccount.CreateAccountPayload;
import com.cbastian90.resources.kernel.domain.util.HeaderObjectInformationErrorResponse;
import com.cbastian90.resources.kernel.domain.util.HeaderObjectInformationResponse;
import com.cbastian90.resources.kernel.domain.util.HttpStatus;
import com.cbastian90.resources.kernel.domain.util.MessageObjectInformationResponse;
import com.cbastian90.resources.kernel.domain.util.models.Account;
import com.cbastian90.resources.kernel.exception.error.UseCaseErrorResponse;
import com.cbastian90.resources.kernel.exception.error.UseCaseErrorResponseError;
import com.cbastian90.resources.ports.database.microservicesdb.client.AccountPort;
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
public class CreateAccountUseCase implements UseCase<CreateAccountCommand, Either<UseCaseErrorResponse, CreateAccountInformation>> {

        private final AccountPort accountPort;
        @Override
        public Either<UseCaseErrorResponse, CreateAccountInformation> execute(CreateAccountCommand command) {
            Either<Throwable, CreateAccountInformation> response =
                    Try.of( () -> {
                        // Do something
                        Account account = accountPort.createAccount(
                                command.getNumeroCuenta(),
                                command.getTipoCuenta(),
                                command.getSaldoInicial(),
                                command.getEstado(),
                                command.getClienteId()
                        ).block(Duration.ofMillis(1000));
                        return buildSuccess(account, HttpStatus.ACCEPTED, command, "Client created successfully");
                    }).toEither();
            return response.isRight()?Either.right(response.get()):Either.left(buildErrorResponse(response.getLeft().getMessage() ));
        }
        private CreateAccountInformation buildSuccess(Account account,HttpStatus httpStatus, CreateAccountCommand command, String messagePayload) {
            return new CreateAccountInformation(
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
                    CreateAccountPayload
                            .builder()
                            .id(account.getAccountId())
                            .clienteId(Long.valueOf(account.getClient().getClientId()))
                            .estado(account.getEstado())
                            .numeroCuenta(account.getNumeroCuenta())
                            .saldoInicial(account.getSaldoInicial())
                            .tipoCuenta(account.getTipoCuenta())
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
