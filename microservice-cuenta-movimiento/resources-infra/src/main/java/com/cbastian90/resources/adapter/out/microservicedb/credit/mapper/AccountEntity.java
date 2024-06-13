package com.cbastian90.resources.adapter.out.microservicedb.credit.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cuenta", schema = "microservice_db")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cuenta", nullable = false)
    private String numeroCuenta;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(name = "saldo_inicial", precision = 15, scale = 2)
    private BigDecimal saldoInicial;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cliente_id")
    private Long clienteId;
}
