package com.cbastian90.resources.adapter.in.readClient;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class ReadClientResponseData implements Serializable {
    private ReadClientResponseDataPerson person;
    private String password;
    private String estado;
    private Integer clientId;
}
