package com.cbastian90.resources.handler.createclient.mapper;

import com.cbastian90.resources.adapter.in.createclient.dto.CreateClientRequest;
import com.cbastian90.resources.adapter.in.createclient.dto.CreateClientResponse;
import com.cbastian90.resources.adapter.in.createclient.dto.CreateClientResponseData;
import com.cbastian90.resources.adapter.in.createclient.dto.CreateClientResponseDataPerson;
import com.cbastian90.resources.adapter.in.util.HeaderObjectResponse;
import com.cbastian90.resources.adapter.in.util.MessageObjectResponse;
import com.cbastian90.resources.kernel.command.createperson.CreateClientCommand;
import com.cbastian90.resources.kernel.domain.createclient.CreateClientInformation;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreateClientMapper {
    public static CreateClientCommand requestToCommand(String authtorization, String messageUid, CreateClientRequest request) {
        return CreateClientCommand
                .builder()
                .authorization(authtorization)
                .messageUid(messageUid)
                .gender(request.getPerson().getGender())
                .estado(request.getState())
                .password(request.getPassword())
                .name(request.getPerson().getName())
                .address(request.getPerson().getAddress())
                .age(request.getPerson().getAge())
                .identification(request.getPerson().getIdentification())
                .phone(request.getPerson().getPhone())
                .build();
    }


    public static CreateClientResponse informationToResponse(CreateClientInformation info) {
        return CreateClientResponse
                .builder()
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
                .data(CreateClientResponseData
                        .builder()
                        .clientId(info.getData().getClientId())
                        .estado(info.getData().getEstado())
                        .password("******")
                        .person(CreateClientResponseDataPerson
                                .builder()
                                .personId(info.getData().getPerson().getPersonId())
                                .phone(info.getData().getPerson().getPhone())
                                .address(info.getData().getPerson().getAddress())
                                .identification(info.getData().getPerson().getIdentification())
                                .name(info.getData().getPerson().getName())
                                .gender(info.getData().getPerson().getGender())
                                .build()
                        )
                        .build()
                )
                .build();
    }
}
