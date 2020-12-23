package com.xyz.apis.payment.persistence.entity;

import com.xyz.apis.payment.common.Currency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT_DETAILS")
@Getter
@Setter
public class AccountEntity implements Serializable {


    private static final long serialVersionUID = 2905774159242405483L;

    @Id
    private long accountNumber;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Currency accountCurrency;

    private long currentBalance;

}
