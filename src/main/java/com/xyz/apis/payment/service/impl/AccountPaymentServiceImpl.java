package com.xyz.apis.payment.service.impl;

import com.xyz.apis.payment.payload.request.AccountPaymentTransferRequest;
import com.xyz.apis.payment.persistence.entity.AccountDetails;
import com.xyz.apis.payment.persistence.entity.AccountTransactions;
import com.xyz.apis.payment.persistence.repository.AccountRepository;
import com.xyz.apis.payment.persistence.repository.AccountTransactionsRepository;
import com.xyz.apis.payment.service.AccountPaymentService;
import com.xyz.apis.payment.service.PaymentValidationService;
import com.xyz.apis.payment.service.mapper.AccountPaymentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AccountPaymentServiceImpl implements AccountPaymentService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentValidationService paymentValidationService;

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @Autowired
    private AccountPaymentsMapper accountPaymentsMapper;


    /**
     *  This method handles account money transfers, tasks being performed -
     *  1. Validate payment request if the request doesn't violate consistency and integrity
     *  2. Maintaining transaction details for later use
     * @param request
     */

    @Override
    @Transactional
    public Long performAccountPayment(AccountPaymentTransferRequest request) {


        Optional<AccountDetails> sourceAccount = accountRepository.findById(request.getSourceAccount());
        Optional<AccountDetails> destinationAccount = accountRepository.findById(request.getDestinationAccount());

        paymentValidationService.validateAccountPaymentTransfer(sourceAccount, destinationAccount, request);

        // If payment validation successful, perform transfer
        // Debit the amount from source account
        sourceAccount.ifPresent( srcAccount ->{
            srcAccount.setCurrentBalance(srcAccount.getCurrentBalance() - request.getAmount());
            accountRepository.save(srcAccount);
        });


        // Credit the amount to Destination account
        destinationAccount.ifPresent( destAccount ->{
            destAccount.setCurrentBalance(destAccount.getCurrentBalance() + request.getAmount());
            accountRepository.save(destAccount);
        });

        // PUT an entry into transaction table
        AccountTransactions transaction =  accountTransactionsRepository.save(accountPaymentsMapper.toAccountTransactionEntity(request));
        return transaction.getId();


    }
}
