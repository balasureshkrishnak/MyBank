package com.hcl.mybank.controller;


import javax.validation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mybank.dto.TransactionRequestDto;
import com.hcl.mybank.dto.TransactionResponseDto;
import com.hcl.mybank.exception.DayLimitReachedException;
import com.hcl.mybank.exception.FromAccountNotFoundException;
import com.hcl.mybank.exception.NotValidBeneficiaryException;
import com.hcl.mybank.exception.ToAccountNotFoundException;
import com.hcl.mybank.service.TransactionService;

/**
 * 
 * @author Bala Suresh Krishna. K
 * @apiNote This api is for transfering the funds between two accounts
 *
 */

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	private static Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/")
	ResponseEntity<TransactionResponseDto> fundTransfer(@Valid @RequestBody TransactionRequestDto transactionRequestDto) throws FromAccountNotFoundException, ToAccountNotFoundException, DayLimitReachedException,NotValidBeneficiaryException{
		logger.info("inside transaction controller");
		TransactionResponseDto transactionResponseDto; 
		transactionResponseDto = transactionService.fundTransfer(transactionRequestDto);
		return new ResponseEntity<>(transactionResponseDto,HttpStatus.OK);
	}

}
