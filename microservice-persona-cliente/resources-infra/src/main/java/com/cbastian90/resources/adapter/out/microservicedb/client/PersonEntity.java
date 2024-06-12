package com.cbastian90.resources.adapter.out.microservicedb.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "persona", schema = "microservice_db")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "genero")
    private String gender;

    @Column(name = "edad")
    private Integer age;

    @Column(name = "identificacion")
    private String identification;

    @Column(name = "direccion")
    private String address;

    @Column(name = "telefono")
    private String phone;

    // Getters and Setters
}