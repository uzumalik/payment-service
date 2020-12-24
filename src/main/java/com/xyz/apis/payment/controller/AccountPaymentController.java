package com.xyz.apis.payment.controller;

import com.xyz.apis.payment.payload.request.AccountPaymentTransferRequest;
import com.xyz.apis.payment.service.AccountPaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@Api(tags = "AccountPaymentController", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(path = "/accounts")
@Slf4j
public class AccountPaymentController {

    @Autowired
    private AccountPaymentService accountPaymentService;

    @PostMapping("/transfer")
    @ApiOperation("API to make account transfers")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> accountTransfer(@RequestBody AccountPaymentTransferRequest request, UriComponentsBuilder builder){
        log.info("making account payments");
        Long transactionId = accountPaymentService.performAccountPayment(request);
            System.out.println("Making payments");

            UriComponents uriComponents = builder.path("transactionId/{id}").buildAndExpand(transactionId);
            return ResponseEntity.created(uriComponents.toUri()).build();

    }
}
