package com.xyz.apis.payment.service.impl;

import com.xyz.apis.payment.exception.ExceptionReason;
import com.xyz.apis.payment.exception.PaymentServiceException;
import com.xyz.apis.payment.payload.response.AccountDetailsResponse;
import com.xyz.apis.payment.persistence.entity.AccountDetails;
import com.xyz.apis.payment.persistence.repository.AccountRepository;
import com.xyz.apis.payment.service.AccountService;
import com.xyz.apis.payment.service.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Mohammad Uzair
 *
 * This service class is for managing account operations
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper mapper;

    /**
     * Method returns the account details, if account number doesn't exist in DB then throws 404
     * @param accountNumber
     * @return
     */
    @Override
    public AccountDetailsResponse getAccountDetails(Long accountNumber){

        log.info("getting account details");
        Optional<AccountDetails> account = accountRepository.findById(accountNumber);
        if (account.isPresent()){
            return mapper.toAccountDetailsResponse(account.get());
        } else {
            throw new PaymentServiceException("Account doesn't exist for account number: "+accountNumber, ExceptionReason.RESOURCE_NOT_FOUND);
        }
    }

}
