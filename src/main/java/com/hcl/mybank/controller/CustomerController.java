package com.hcl.mybank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.hcl.mybank.dto.CustomerRequestDto;
import com.hcl.mybank.dto.CustomerResponseDto;
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
}
