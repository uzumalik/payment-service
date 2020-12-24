package com.xyz.apis.payment.payload.request;

import com.xyz.apis.payment.common.Currency;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel
@Getter
@Setter
@Validated
public class AccountPaymentTransferRequest {

    @NotNull
    @ApiModelProperty("Customer Id")
    private Long customerId;

    @NotNull
    @ApiModelProperty("Source Account")
    private Long sourceAccount;

    @NotNull
    @ApiModelProperty("Destination Account")
    private Long destinationAccount;

    @ApiModelProperty("Payment amount")
    private double amount;

    @ApiModelProperty("Currency")
    private Currency currency;

    @ApiModelProperty("Remarks")
    private String remarks;


}
