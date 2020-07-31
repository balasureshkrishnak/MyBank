package com.hcl.mybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

//	@Query("select p from Person p where p.forename = :forename and p.surname = :surname")
	List<Transaction> findByFromAccountNumberOrToAccountNumber(String accountNumber, String accountNumber1);

	
	

}
