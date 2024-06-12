package com.cbastian90.resources.adapter.in.createclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Validated
public class CreateClientRequestPerson implements Serializable {
    @JsonProperty("nombre")
    private String name;

    @JsonProperty("genero")
    private String gender;

    @JsonProperty("edad")
    private Integer age;

    @NotNull(message = "identificacion")
    @JsonProperty("identificacion")
    private String identification;

    @JsonProperty("direccion")
    private String address;

    @JsonProperty("telefono")
    private String phone;
}
