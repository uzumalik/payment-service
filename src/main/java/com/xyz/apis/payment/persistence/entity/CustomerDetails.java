package com.xyz.apis.payment.persistence.entity;

import com.xyz.apis.payment.common.Gender;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER_DETAILS")
@Getter
@Setter
public class CustomerDetails extends BaseEntity {

    private static final long serialVersionUID = 8887101398822362433L;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER_ID")
    private long customerId;

    private String title;

    private String firstName;

    private String middleName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "customer")
    private AccountEntity accountEntity;


}
