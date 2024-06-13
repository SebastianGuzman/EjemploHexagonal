package com.cbastian90.resources.adapter.out.webclient.personacliente.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder //TODO solo para proceso de pruebas, borrar @Builder cuando se consuma el servicio
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaClienteDtoResponseMessage implements Serializable {
    private int responseCode;
    private String responseMessage;
    private String responseDetails;

}
