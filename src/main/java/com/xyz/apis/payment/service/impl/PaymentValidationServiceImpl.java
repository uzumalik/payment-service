package com.xyz.apis.payment.service.impl;

import com.xyz.apis.payment.exception.ExceptionReason;
import com.xyz.apis.payment.exception.PaymentServiceException;
import com.xyz.apis.payment.payload.request.AccountPaymentTransferRequest;
import com.xyz.apis.payment.persistence.entity.AccountDetails;
import com.xyz.apis.payment.service.PaymentValidationService;

import javax.print.attribute.standard.Destination;

/**
 *
 * @author Mohammad Uzair
 *
 * This class perform payment validations
 */
public class PaymentValidationServiceImpl implements PaymentValidationService {

    /**
     *
     * @param sourceAccount
     * @param destinationAccount
     * @param request
     *
     * This method will perform that if the payment request is allowed to proceed
     */
    @Override
    public void validateAccountPaymentTransfer(AccountDetails sourceAccount,
                                               AccountDetails destinationAccount,
                                               AccountPaymentTransferRequest request){

        if (null == sourceAccount ){
            throw new PaymentServiceException("Source Account Doesn't exist", ExceptionReason.INVALID_SOURCE_ACCOUNT);
        }

        if (null == destinationAccount){
            throw new PaymentServiceException("Destination Account Doesn't exist", ExceptionReason.INVALID_DESTINATION_ACCOUNT);
        }

        if (sourceAccount.getCurrentBalance() - request.getAmount() < 0){
            throw new PaymentServiceException("Insuffecient Balance in Source account", ExceptionReason.INSUFFECIENT_BALANCE);

        }

    }

}
