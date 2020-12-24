package com.xyz.apis.payment.persistence.repository;

import com.xyz.apis.payment.persistence.entity.AccountTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, Long> {
}
