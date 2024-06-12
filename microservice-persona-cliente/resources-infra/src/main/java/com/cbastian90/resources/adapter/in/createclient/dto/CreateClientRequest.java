package com.cbastian90.resources.adapter.in.createclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Validated
public class CreateClientRequest implements Serializable {
    @JsonProperty("persona")
    private CreateClientRequestPerson person;
    @JsonProperty("contrasena")
    private String password;
    @JsonProperty("estado")
    private String state;
    @JsonProperty("id")
    private Integer clientId;
}

