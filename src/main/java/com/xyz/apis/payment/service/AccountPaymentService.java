package com.xyz.apis.payment.service;

import com.xyz.apis.payment.payload.request.AccountPaymentTransferRequest;

public interface AccountPaymentService {

    public Long performAccountPayment(AccountPaymentTransferRequest requests);
}
