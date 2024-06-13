package com.cbastian90.resources.handler.createaccount.mapper;

import com.cbastian90.resources.adapter.in.createaccount.dto.CreateAccountRequest;
import com.cbastian90.resources.adapter.in.createaccount.dto.CreateAccountResponse;
import com.cbastian90.resources.adapter.in.createaccount.dto.CreateAccountResponseData;
import com.cbastian90.resources.adapter.in.util.HeaderObjectResponse;
import com.cbastian90.resources.adapter.in.util.MessageObjectResponse;
import com.cbastian90.resources.kernel.command.createaccount.CreateAccountCommand;
import com.cbastian90.resources.kernel.domain.createaccount.CreateAccountInformation;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreateAccountMapper {
    public static CreateAccountCommand requestToCommand(String authorization, String messageUid, CreateAccountRequest createClientRequest) {
        return CreateAccountCommand.builder()
                .authorization(authorization)
                .messageUid(messageUid)
                .numeroCuenta(createClientRequest.getNumeroCuenta())
                .tipoCuenta(createClientRequest.getTipoCuenta())
                .saldoInicial(createClientRequest.getSaldoInicial())
                .estado(createClientRequest.getEstado())
                .clienteId(createClientRequest.getClienteId())
                .build();
    }

    public static CreateAccountResponse informationToResponse(CreateAccountInformation info) {
        return CreateAccountResponse.builder()
                .headers(
                        HeaderObjectResponse
                                .builder()
                                .messageUid(info.getHeaders().getMessageUuid())
                                .requestDatetime(info.getHeaders().getRequestDatetime())
                                .httpStatusCode(info.getHeaders().getHttpStatusCode())
                                .httpStatusDesc(info.getHeaders().getHttpStatusDesc())
                                .build()
                )
                .messageResponse(
                        MessageObjectResponse
                                .builder()
                                .responseCode(info.getMessageResponse().getResponseCode())
                                .responseMessage(info.getMessageResponse().getResponseMessage())
                                .responseDetails(info.getMessageResponse().getResponseDetail())
                                .build()
                )
                .data(
                        CreateAccountResponseData
                                .builder()
                                .build()
                ).build()

                ;
    }
}
