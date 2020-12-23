package com.xyz.apis.payment.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "PaymentController", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(path = "/accounts")
public class PaymentController {


    @PutMapping("/transfer")
    @ApiOperation("API to make account transfers")
    public void accountTransfer(){

            System.out.println("Making payments");

    }
}
