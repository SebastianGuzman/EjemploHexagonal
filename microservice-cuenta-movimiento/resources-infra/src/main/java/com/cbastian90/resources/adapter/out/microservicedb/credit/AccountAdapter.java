package com.cbastian90.resources.adapter.out.microservicedb.credit;

import com.cbastian90.resources.adapter.out.microservicedb.credit.mapper.AccountEntity;
import com.cbastian90.resources.adapter.out.microservicedb.credit.mapper.AccountMapper;
import com.cbastian90.resources.adapter.out.microservicedb.credit.mapper.AccountRepository;
import com.cbastian90.resources.kernel.domain.util.models.Account;
import com.cbastian90.resources.ports.database.microservicesdb.client.AccountPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Slf4j
public class AccountAdapter implements AccountPort {

    @Autowired
    AccountRepository accountRepository;
    private static final String CONSUMO_EXITOSO="consumo exitoso";
    private static final String ERROR_CREAR_TRANSACCION = "Error, no se creó transaccion";

    @Override
    public Mono<Account> createAccount(String numeroCuenta, String tipoCuenta, BigDecimal saldoInicial, String estado, Long clienteId) {
        return Mono.fromSupplier( ()->
                accountRepository.save( AccountEntity
                        .builder()
                        .numeroCuenta(numeroCuenta)
                        .tipoCuenta(tipoCuenta)
                        .saldoInicial(saldoInicial)
                        .estado(estado)
                        .clienteId(clienteId)
                        .build()
                )
        )
                .map(AccountMapper::entityToAccount)
                .doOnSuccess(m -> log.info(CONSUMO_EXITOSO))
                .onErrorResume(e -> {
                    log.error(ERROR_CREAR_TRANSACCION);
                    return Mono.error(new RuntimeException(e.getMessage()));
                });
    }
}
