package com.cbastian90.resources.kernel.exception.error.mapper;

import com.cbastian90.resources.kernel.exception.error.UseCaseErrorResponseError;
import com.cbastian90.resources.kernel.domain.util.HeaderObjectInformationErrorResponse;
import com.cbastian90.resources.kernel.domain.util.MessageObjectInformationResponse;
import com.cbastian90.resources.kernel.exception.error.UseCaseErrorResponse;

public class UseCaseErrorResponseMapper {
    public static UseCaseErrorResponse buildErrorResponse(Integer httpStatusCode, String htttpStatusDesc, String timestamp, Integer responseCode, String responseMessage, String responseDetail, String errorCode, String errorDetail) {

        return new UseCaseErrorResponse(
                HeaderObjectInformationErrorResponse
                        .builder()
                        .httpStatusCode(httpStatusCode)
                        .htttpStatusDesc(htttpStatusDesc)
                        .timestamp(timestamp)
                        .build(),
                MessageObjectInformationResponse
                        .builder()
                        .responseCode(responseCode)
                        .responseMessage(responseMessage)
                        .responseDetail(responseDetail)
                        .build(),
                UseCaseErrorResponseError
                        .builder()
                        .errorCode(errorCode)
                        .errorDetail(errorDetail)
                        .build()
        );
    }
}
