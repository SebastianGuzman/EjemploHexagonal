package com.cbastian90.resources.adapter.in.readClient;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
@Builder
@Getter
public class ReadClientResponseDataPerson implements Serializable {
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
    private Integer personId;
}
