package com.xyz.apis.payment.exception;

import lombok.Getter;

/**
 * @author Mohammad Uzair
 * Custom exception class for payment-service
 */
@Getter
public class PaymentServiceException extends RuntimeException{


    private static final long serialVersionUID = 7948174494071096432L;

    private ExceptionReason reason;

    public PaymentServiceException(String message){
        super(message);
    }

    /**
     *
     * @param reason
     * @param message
     * Customer exception with message and exception reason
     */
    public PaymentServiceException( String message, ExceptionReason reason){
        this(message);
        this.reason = reason;
    }


}
