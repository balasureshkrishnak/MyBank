package com.hcl.mybank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.hcl.mybank.dto.AccountSummaryDto;
import com.hcl.mybank.dto.CustomerRequestDto;
import com.hcl.mybank.dto.CustomerResponseDto;
import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Customer;
import com.hcl.mybank.service.CustomerService;
/**
 * this class meant for customer login
 * @author GVK
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	Logger logger=LoggerFactory.getLogger(CustomerController.class);
	/**
	 * 
	 * @param customerRequestDto
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<CustomerResponseDto> login(@RequestBody CustomerRequestDto customerRequestDto){
    customerService.login(customerRequestDto);
	
		return new ResponseEntity<CustomerResponseDto>(HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/customers/{customerId/accounts}")
	public ResponseEntity<List<AccountSummaryDto>> getAccountSummary(@PathVariable Integer customerId) {
		try {
			return new ResponseEntity<>(customerService.getAccountSummary(customerId),
					HttpStatus.OK);
		} catch (AccountNotFoundException message) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, message.getMessage());
		}
	}
}
