package com.cbastian90.resources.kernel.domain.readClient;

import com.cbastian90.resources.kernel.domain.util.AbstractInformationResponse;
import com.cbastian90.resources.kernel.domain.util.HeaderObjectInformationResponse;
import com.cbastian90.resources.kernel.domain.util.MessageObjectInformationResponse;

public class ReadClientInformation extends AbstractInformationResponse<ReadClientPayload> {
    public ReadClientInformation(HeaderObjectInformationResponse headers, MessageObjectInformationResponse messageResponse, ReadClientPayload data) {
        super(headers, messageResponse, data);
    }
}
