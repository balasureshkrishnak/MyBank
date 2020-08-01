package com.hcl.mybank.service;

import org.springframework.http.ResponseEntity;

import com.hcl.mybank.dto.CustomerRequestDto;
import com.hcl.mybank.dto.CustomerResponseDto;

public interface CustomerService {

	String login(CustomerRequestDto customerRequestDto);
		

}
