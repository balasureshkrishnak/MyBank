package com.hcl.mybank.service;

import com.hcl.mybank.dto.TransactionRequestDto;
import com.hcl.mybank.dto.TransactionResponseDto;
import com.hcl.mybank.exception.DayLimitReachedException;
import com.hcl.mybank.exception.FromAccountNotFoundException;
import com.hcl.mybank.exception.NotValidBeneficiaryException;
import com.hcl.mybank.exception.ToAccountNotFoundException;

public interface TransactionService {

	public TransactionResponseDto fundTransfer(TransactionRequestDto transactionRequestDto)
			throws FromAccountNotFoundException, ToAccountNotFoundException, DayLimitReachedException,
			NotValidBeneficiaryException;

}
