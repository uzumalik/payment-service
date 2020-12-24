package com.xyz.apis.payment.payload.request;

import com.xyz.apis.payment.common.Currency;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@ApiModel
@Getter
@Setter
@Validated
public class AccountPaymentTransferRequest {

    @ApiModelProperty("Source Account")
    private Long sourceAccount;

    @ApiModelProperty("Destination Account")
    private Long destinationAccount;

    @ApiModelProperty("Payment amount")
    private double amount;

    @ApiModelProperty("Currency")
    private Currency currency;

    @ApiModelProperty("Remarks")
    private String remarks;


}
