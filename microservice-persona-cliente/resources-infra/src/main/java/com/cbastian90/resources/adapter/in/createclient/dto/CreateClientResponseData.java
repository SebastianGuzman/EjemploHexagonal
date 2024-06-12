package com.cbastian90.resources.adapter.in.createclient.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class CreateClientResponseData implements Serializable {
    private CreateClientResponseDataPerson person;
    private String password;
    private String estado;
    private Integer clientId;
}
