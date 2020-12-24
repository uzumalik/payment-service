package com.xyz.apis.payment.persistence.repository;

import com.xyz.apis.payment.persistence.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Mohammad Uzair
 */

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Long> {

    // get the account by account id
    Optional<AccountDetails> findById(Long id);
}
