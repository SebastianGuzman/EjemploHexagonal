package com.cbastian90.resources.ports.database.microservicesdb.client;

import com.cbastian90.resources.kernel.domain.util.models.Account;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface AccountPort {
    Mono<Account> createAccount (
            String numeroCuenta,
            String tipoCuenta,
            BigDecimal saldoInicial,
            String estado,
            Long clienteId
    );

}
