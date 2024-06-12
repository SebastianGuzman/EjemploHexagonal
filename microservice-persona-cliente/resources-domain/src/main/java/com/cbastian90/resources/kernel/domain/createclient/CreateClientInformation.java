package com.cbastian90.resources.kernel.domain.createclient;

import com.cbastian90.resources.kernel.domain.util.AbstractInformationResponse;
import com.cbastian90.resources.kernel.domain.util.HeaderObjectInformationResponse;
import com.cbastian90.resources.kernel.domain.util.MessageObjectInformationResponse;

public class CreateClientInformation extends AbstractInformationResponse<CreateClientPayload> {
    public CreateClientInformation(HeaderObjectInformationResponse headers, MessageObjectInformationResponse messageResponse, CreateClientPayload data) {
        super(headers, messageResponse, data);
    }
}
