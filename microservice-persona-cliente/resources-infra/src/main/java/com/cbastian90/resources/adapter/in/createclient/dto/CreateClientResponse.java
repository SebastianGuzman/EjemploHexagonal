package com.cbastian90.resources.adapter.in.createclient.dto;

import com.cbastian90.resources.adapter.in.util.GenericResponse;
import com.cbastian90.resources.adapter.in.util.HeaderObjectResponse;
import com.cbastian90.resources.adapter.in.util.MessageObjectResponse;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class CreateClientResponse implements GenericResponse, Serializable {
    private HeaderObjectResponse headers;
    private MessageObjectResponse messageResponse;
    private CreateClientResponseData data;
}
