package com.xyz.apis.payment.service;

import com.xyz.apis.payment.helper.MockedPayloads;
import com.xyz.apis.payment.payload.response.AccountDetailsResponse;
import com.xyz.apis.payment.persistence.entity.AccountDetails;
import com.xyz.apis.payment.persistence.repository.AccountRepository;
import com.xyz.apis.payment.service.impl.AccountServiceImpl;
import com.xyz.apis.payment.service.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

/**
 * @author Mohammad Uzair
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper accountMapper;

    @Test
    public void testGetAccountDetails(){

        AccountDetails accountDetails = MockedPayloads.getAccountDetailsEntity();
        AccountDetailsResponse mockedResponse = MockedPayloads.getAccountDetailsResponse();
        when(accountRepository.findById(101l)).thenReturn(Optional.of(accountDetails));
        when(accountMapper.toAccountDetailsResponse(accountDetails)).thenReturn(mockedResponse);

        AccountDetailsResponse methodResponse=  accountService.getAccountDetails(101l);

        assertEquals(methodResponse.getAccountNumber(),mockedResponse.getAccountNumber());
        assertEquals(methodResponse.getAccountType(),mockedResponse.getAccountType());
        assertEquals(methodResponse.getCurrentBalance(),mockedResponse.getCurrentBalance(),0);
    }




}
