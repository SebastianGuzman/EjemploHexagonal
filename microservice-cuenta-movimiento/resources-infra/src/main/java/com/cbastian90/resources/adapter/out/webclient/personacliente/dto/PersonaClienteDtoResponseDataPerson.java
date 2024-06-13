package com.cbastian90.resources.adapter.out.webclient.personacliente.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder //TODO solo para proceso de pruebas, borrar @Builder cuando se consuma el servicio
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaClienteDtoResponseDataPerson
{
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
    private Long personId;
}
