package com.xyz.apis.payment.persistence.entity;

import com.xyz.apis.payment.common.Currency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_DETAILS")
@Getter
@Setter
public class AccountDetails extends BaseEntity {

    private static final long serialVersionUID = 792105238433777524L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCOUNT_NUMBER")
    private long accountNumber;

    @Enumerated(EnumType.STRING)
    private Currency accountCurrency;

    private long currentBalance;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey( name = "CUSTOMER_ID"), referencedColumnName = "CUSTOMER_ID")
    private CustomerDetails customerDetails;

}