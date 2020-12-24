package com.xyz.apis.payment.service.mapper;

import com.xyz.apis.payment.payload.response.AccountDetailsResponse;
import com.xyz.apis.payment.persistence.entity.AccountDetails;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * @author Mohammad Uzair
 *
 * This mapper is used to map objects for account operations
 */


@Component
public class AccountMapper {

    public AccountDetailsResponse toAccountDetailsResponse(AccountDetails accountDetails){

        return AccountDetailsResponse
                .builder()
                .accountNumber(accountDetails.getAccountNumber())
                .accountType(accountDetails.getAccountType())
                .accountCurrency(accountDetails.getAccountCurrency())
                .currentBalance(accountDetails.getCurrentBalance())
                .createdOn(accountDetails.getCreatedAt())
                .lastModifiedOn(accountDetails.getModifiedAt())
                .build();
    }
}
