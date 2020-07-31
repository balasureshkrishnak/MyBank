package com.hcl.mybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mybank.dto.TransactionRequestDto;
import com.hcl.mybank.dto.TransactionResponseDto;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
//	@Autowired
	
	
	ResponseEntity<TransactionResponseDto> fundTransfer(@RequestBody TransactionRequestDto transactionRequestDto) {
		TransactionResponseDto transactionResponseDto = new TransactionResponseDto(); //change this
//		transactionResponseDto = transactionService.fundTransfer(transactionRequestDto);
		return new ResponseEntity<>(transactionResponseDto,HttpStatus.OK);
	}

}
