package com.xyz.apis.payment.service;

import com.xyz.apis.payment.payload.request.AccountPaymentTransferRequest;
import com.xyz.apis.payment.persistence.entity.AccountDetails;

/**
 * @author Mohammad Uzair
 *
 */
public interface PaymentValidationService {

    public void validateAccountPaymentTransfer(AccountDetails sourceAccount, AccountDetails destinationAccount, AccountPaymentTransferRequest request);
}
