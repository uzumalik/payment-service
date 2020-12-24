package com.xyz.apis.payment.service.impl;

import com.xyz.apis.payment.payload.request.AccountPaymentTransferRequest;
import com.xyz.apis.payment.persistence.entity.AccountDetails;
import com.xyz.apis.payment.persistence.repository.AccountRepository;
import com.xyz.apis.payment.service.AccountPaymentService;
import com.xyz.apis.payment.service.PaymentValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountPaymentServiceImpl implements AccountPaymentService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentValidationService paymentValidationService;

    @Override
    @Transactional
    public void performAccountPayment(AccountPaymentTransferRequest request) {


        AccountDetails sourceAccount = accountRepository.getOne(request.getSourceAccount());
        AccountDetails destinationAccount = accountRepository.getOne(request.getDestinationAccount());

        paymentValidationService.validateAccountPaymentTransfer(sourceAccount, destinationAccount, request);

        // If payment validation successful, perform transfer
        sourceAccount.setCurrentBalance(sourceAccount.getCurrentBalance() - request.getAmount());




    }
}
