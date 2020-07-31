package com.hcl.mybank.service;

import com.hcl.mybank.dto.AccountDetailsDto;
import com.hcl.mybank.exception.AccountNotFoundException;

public interface AccountService {

	public AccountDetailsDto getAccountDetails(String accountnumber) throws AccountNotFoundException;
}
