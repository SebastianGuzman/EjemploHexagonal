package com.cbastian90.resources.adapter.in.createclient.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class CreateClientResponseDataPerson implements Serializable {
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
    private Integer personId;
}
