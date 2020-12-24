package com.xyz.apis.payment.service.mapper;

import com.xyz.apis.payment.common.PaymentStatus;
import com.xyz.apis.payment.common.TransactionType;
import com.xyz.apis.payment.payload.request.AccountPaymentTransferRequest;
import com.xyz.apis.payment.persistence.entity.AccountTransactions;
import org.springframework.stereotype.Component;

/**
 * @author Mohammad Uzair
 *
 * This class contains method for custom objects mappings
 */
@Component
public class AccountPaymentsMapper {

    public AccountTransactions toAccountTransactionEntity(AccountPaymentTransferRequest request){
        AccountTransactions transaction = new AccountTransactions();

        transaction.setSourceAccount(request.getSourceAccount());
        transaction.setDestinationAccount(request.getDestinationAccount());
        transaction.setTransactionAmount(request.getAmount());
        transaction.setTransactionType(TransactionType.ACCOUNT_DEBIT);
        transaction.setStatus(PaymentStatus.SUCCESS.getValue());
        transaction.setRemarks(request.getRemarks());
        return transaction;
    }
}
