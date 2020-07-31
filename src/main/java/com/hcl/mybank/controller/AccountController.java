package com.hcl.mybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hcl.mybank.dto.AccountDetailsDto;
import com.hcl.mybank.exception.AccountNotFoundException;
import com.hcl.mybank.service.AccountImplService;

/**
 * @author Rahul
 *
 */
@RestController
public class AccountController {

	@Autowired
	AccountImplService accountImplService;

	@GetMapping("/accounts/{accountNumber}")
	public ResponseEntity<AccountDetailsDto> getAccountDetails(@PathVariable String accountNumber) {
		try {
			return new ResponseEntity<>(accountImplService.getAccountDetails(accountNumber),
					HttpStatus.OK);
		} catch (AccountNotFoundException mess) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, mess.getMessage());
		}
	}
}
