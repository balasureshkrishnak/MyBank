package com.hcl.mybank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.entity.Account;

/**
 * @author Rahul
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{


	Optional<Account> findByAccountNumber(String accountNumber);

}
