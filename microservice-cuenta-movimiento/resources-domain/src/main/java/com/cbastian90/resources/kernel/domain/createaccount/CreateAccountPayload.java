package com.cbastian90.resources.kernel.domain.createaccount;

import com.cbastian90.resources.kernel.domain.util.InformationPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateAccountPayload implements Serializable, InformationPayload {
    private Long id;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private String estado;
    private Long clienteId;
}
