package com.hcl.mybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mybank.dto.AccountSummaryDto;
import com.hcl.mybank.dto.CustomerResponseDto;
import com.hcl.mybank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public CustomerResponseDto findByCustomerIdAndPassword(Integer customerId,String password);
	public List<AccountSummaryDto> findByCustomerId(Integer id);
}
