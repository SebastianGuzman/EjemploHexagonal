package com.cbastian90.resources.adapter.out.microservicedb.credit.mapper;

import com.cbastian90.resources.kernel.domain.util.models.Account;
import com.cbastian90.resources.kernel.domain.util.models.Client;

public class AccountMapper {
    public static Account entityToAccount(AccountEntity accountEntity) {
        return Account
                .builder()
                .accountId(accountEntity.getId())
                .client(Client.builder().build())
                .estado(accountEntity.getEstado())
                .numeroCuenta(accountEntity.getNumeroCuenta())
                .saldoInicial(accountEntity.getSaldoInicial())
                .tipoCuenta(accountEntity.getTipoCuenta())
                .build();
    }
}
