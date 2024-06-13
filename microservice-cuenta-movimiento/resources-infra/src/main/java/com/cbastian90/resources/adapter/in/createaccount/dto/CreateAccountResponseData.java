package com.cbastian90.resources.adapter.in.createaccount.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class CreateAccountResponseData implements Serializable {
    private String message;
}
