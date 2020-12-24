package com.xyz.apis.payment.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Mohammad Uzair
 * This Enum represents payment status
 */
@AllArgsConstructor
@Getter
public enum PaymentStatus {
    FAILED(0),
    SUCCESS(1),
    PENDING(2),
    DECLINED(3);

    private final int value;
}
