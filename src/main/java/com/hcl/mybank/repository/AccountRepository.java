package com.hcl.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	List<Account> findByaccountNo(Long accountNumber);

}
