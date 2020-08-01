package com.hcl.mybank.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.hcl.mybank.entity.Account;
import com.hcl.mybank.dto.AccountSummaryDto;
import com.hcl.mybank.dto.CustomerRequestDto;
import com.hcl.mybank.dto.CustomerResponseDto;

public interface CustomerService {

	String login(CustomerRequestDto customerRequestDto);

	List<AccountSummaryDto> getAccountSummary(Integer customerId);
		

}
