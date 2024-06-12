package com.cbastian90.resources.kernel.domain.util;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;

@Builder
@AllArgsConstructor
public class MessageObjectInformationResponse implements Serializable {

    private Integer responseCode;
    private String responseMessage;
    private String responseDetail;

    public Integer getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public String getResponseDetail() {
        return responseDetail;
    }
}
