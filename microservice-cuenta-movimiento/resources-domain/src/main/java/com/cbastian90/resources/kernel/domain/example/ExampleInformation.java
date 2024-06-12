package com.cbastian90.resources.kernel.domain.example;

import com.cbastian90.resources.kernel.domain.util.AbstractInformationResponse;
import com.cbastian90.resources.kernel.domain.util.HeaderObjectInformationResponse;
import com.cbastian90.resources.kernel.domain.util.MessageObjectInformationResponse;

public class ExampleInformation extends AbstractInformationResponse<ExampleInformationPayload> {
    public ExampleInformation(HeaderObjectInformationResponse headers,
                              MessageObjectInformationResponse messageResponse,
                              ExampleInformationPayload data) {
        super(headers, messageResponse, data);
    }
}
