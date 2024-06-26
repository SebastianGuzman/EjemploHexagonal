package com.cbastian90.resources.adapter.in.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeaderObjectResponse implements Serializable {
    private String messageUid;
    private String requestDatetime;
    private String requestAppId;
    private Integer httpStatusCode;
    private String httpStatusDesc;
}