package com.xyz.apis.payment.persistence.repository;

import com.xyz.apis.payment.persistence.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Long> {


    Optional<AccountDetails> findById(Long id);
}
