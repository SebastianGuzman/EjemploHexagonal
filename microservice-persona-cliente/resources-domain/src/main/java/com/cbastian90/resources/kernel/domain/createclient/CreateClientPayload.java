package com.cbastian90.resources.kernel.domain.createclient;

import com.cbastian90.resources.kernel.domain.util.InformationPayload;
import com.cbastian90.resources.kernel.domain.util.models.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateClientPayload implements Serializable, InformationPayload {
    Person person;
    private String password;
    private String estado;
    private Integer clientId;
}
