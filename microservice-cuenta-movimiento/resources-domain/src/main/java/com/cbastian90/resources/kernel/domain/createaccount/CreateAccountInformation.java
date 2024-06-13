package com.cbastian90.resources.kernel.domain.createaccount;

import com.cbastian90.resources.kernel.domain.util.AbstractInformationResponse;
import com.cbastian90.resources.kernel.domain.util.HeaderObjectInformationResponse;
import com.cbastian90.resources.kernel.domain.util.MessageObjectInformationResponse;

public class CreateAccountInformation extends AbstractInformationResponse<CreateAccountPayload> {
    public CreateAccountInformation(HeaderObjectInformationResponse headers, MessageObjectInformationResponse messageResponse, CreateAccountPayload data) {
        super(headers, messageResponse, data);
    }
}
