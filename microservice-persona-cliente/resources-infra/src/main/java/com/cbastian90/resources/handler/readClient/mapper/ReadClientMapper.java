package com.cbastian90.resources.handler.readClient.mapper;

import com.cbastian90.resources.adapter.in.readClient.ReadClientResponse;
import com.cbastian90.resources.adapter.in.readClient.ReadClientResponseData;
import com.cbastian90.resources.adapter.in.readClient.ReadClientResponseDataPerson;
import com.cbastian90.resources.adapter.in.util.HeaderObjectResponse;
import com.cbastian90.resources.adapter.in.util.MessageObjectResponse;
import com.cbastian90.resources.kernel.command.readClient.ReadClientCommand;
import com.cbastian90.resources.kernel.domain.readClient.ReadClientInformation;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReadClientMapper {
    public static ReadClientCommand requestToCommand(String authorization, String messageUid, Long clientId) {
        return ReadClientCommand.builder()
                .authorization(authorization)
                .messageUid(messageUid)
                .clientId(clientId)
                .build();
    }

    public static ReadClientResponse informationToResponse(ReadClientInformation info) {
        return ReadClientResponse
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
                .data(ReadClientResponseData
                        .builder()
                        .clientId(info.getData().getClientId())
                        .estado(info.getData().getEstado())
                        .password("******")
                        .person(ReadClientResponseDataPerson
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
