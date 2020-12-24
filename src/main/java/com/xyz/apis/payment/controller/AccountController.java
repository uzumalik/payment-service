package com.xyz.apis.payment.controller;


import com.xyz.apis.payment.payload.response.AccountDetailsResponse;
import com.xyz.apis.payment.persistence.entity.AccountDetails;
import com.xyz.apis.payment.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Api(tags = "AccountsController", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AccountController {


    @Autowired
    private AccountService accountService;


    @ApiOperation("API to get accounts")
    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDetailsResponse> getAccountDetails(@PathVariable("accountNumber") Long accountNumber){

        log.info("getting account from service");
        return ResponseEntity.ok(accountService.getAccountDetails(accountNumber));

    }
}
