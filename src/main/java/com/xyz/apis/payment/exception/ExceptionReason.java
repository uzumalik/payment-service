package com.xyz.apis.payment.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionReason {

    INVALID_DESTINATION_ACCOUNT(HttpStatus.BAD_REQUEST),
    INVALID_SOURCE_ACCOUNT(HttpStatus.BAD_REQUEST),
    INSUFFECIENT_BALANCE(HttpStatus.BAD_REQUEST);

    private HttpStatus httpStatus;
}
