package com.xyz.apis.payment.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Mohammad Uzair
 * This class is for custom configuartion for payments
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "payments")
@Getter
@Setter
public class PaymentConfig {

    private Account account;

    @Getter
    @Setter
    public static class Account{
        private double minTransferAmount;
    }


}
