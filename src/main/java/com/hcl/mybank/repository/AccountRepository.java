package com.hcl.mybank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	public Optional<Account> findByAccountNumber(String accountNumber);
	

}
