package com.cbastian90.resources.kernel.domain.util.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    private Person person;
    private String password;
    private String estado;
    private Integer clientId;
}
