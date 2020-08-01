package com.hcl.mybank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.mybank.controller.CustomerController;
import com.hcl.mybank.dto.CustomerRequestDto;
import com.hcl.mybank.dto.CustomerResponseDto;
import com.hcl.mybank.entity.Customer;
import com.hcl.mybank.repository.CustomerRepository;
/**
 * this class meant for customer login
 * @author GVK
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
	CustomerRepository customerRepository;
    Logger logger=LoggerFactory.getLogger(CustomerServiceImpl.class);
  /**
   * 
   */
	@Override
	public String login(CustomerRequestDto customerRequestDto) {
		Integer customerId = customerRequestDto.getCustomerId();
		String password = customerRequestDto.getPassword();
		
		CustomerResponseDto customerResponseDto = new CustomerResponseDto();
		
		 customerRepository.findByCustomerIdAndPassword(customerId, password);
		 customerResponseDto.setMessage("Success");
		 customerResponseDto.setStatusCode(200);
		 
		return "Success";
	}

}
