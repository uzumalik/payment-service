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
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER_DETAILS")
@Getter
@Setter
public class CustomerDetails extends BaseEntity {

    private static final long serialVersionUID = 8887101398822362433L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER_ID")
    @SequenceGenerator(name = "SEQ_CUSTOMER_ID", allocationSize = 1)
    private Long customerId;

    private String title;

    private String firstName;

    private String middleName;

    private String LastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    /*@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "customer")
    private AccountDetails accountDetails;*/


}
