package com.xyz.apis.payment.service;

import com.xyz.apis.payment.payload.request.AccountPaymentTransferRequest;
import com.xyz.apis.payment.persistence.entity.AccountDetails;

import java.util.Optional;

/**
 * @author Mohammad Uzair
 *
 */
public interface PaymentValidationService {

    public void validateAccountPaymentTransfer(Optional<AccountDetails> sourceAccount, Optional<AccountDetails> destinationAccount, AccountPaymentTransferRequest request);
}
