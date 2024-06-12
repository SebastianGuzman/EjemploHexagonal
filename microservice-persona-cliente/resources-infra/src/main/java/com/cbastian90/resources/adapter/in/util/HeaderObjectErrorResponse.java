package com.cbastian90.resources.adapter.in.util;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HeaderObjectErrorResponse {
    private Integer httpStatusCode;
    private String htttpStatusDesc;
    private String timestamp;

}