package com.cbastian90.resources.adapter.in.createaccount.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Validated
public class CreateAccountRequest implements Serializable {
    @JsonProperty("numerocuenta")
    private String numeroCuenta;

    @JsonProperty("tipo")
    private String tipoCuenta;

    @JsonProperty("saldo")
    private BigDecimal saldoInicial;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("idcliente")
    private Long clienteId;
}
