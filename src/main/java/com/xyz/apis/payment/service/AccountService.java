package com.xyz.apis.payment.service;

import com.xyz.apis.payment.payload.response.AccountDetailsResponse;

/**
 * @author Mohammad Uzair
 */

public interface AccountService {

    public AccountDetailsResponse getAccountDetails(Long accountNumber);
}
