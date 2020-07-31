package com.hcl.mybank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.mybank.dto.AccountDetailsDto;
import com.hcl.mybank.dto.TransactionDto;
import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.exception.AccountNotFoundException;
import com.hcl.mybank.repository.AccountRepository;
import com.hcl.mybank.repository.TransactionRepository;

/**
 * @author Rahul
 *
 */
@Service
public class AccountImplService implements AccountService {

	private static final String ACCOUNT_NOT_EXCEPTION = "Account not found";
	private static final String ACCOUNT_TYPE_DEBIT = "Debit";
	private static final String ACCOUNT_TYPE_CREDIT = "Credit";
	private static final String ACCOUNT_DETAILS_MESSAGE = "Account details";

	private static Logger logger = Logger.getLogger(AccountImplService.class);

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	/**
	 * return accountDetailsDto
	 * @getAccountDetails
	 */
	public AccountDetailsDto getAccountDetails(String accountNumber) throws AccountNotFoundException {
		logger.info("from account details service");

		AccountDetailsDto accountDetailsDto = new AccountDetailsDto();
		List<TransactionDto> transactionDtos = new ArrayList();

		// get account details Data
		Optional<Account> accounts = accountRepository.findByAccountNumber(accountNumber);
		if (accounts.isPresent()) {
			logger.info("account number is " + accounts.get().getAccountNumber());
			Account account = accounts.get();
			accountDetailsDto.setAccountNumber(account.getAccountNumber());
			accountDetailsDto.setAvailableBalance(account.getAvailableBalance());
			accountDetailsDto.setAccountCreationDate(account.getAccountCreationDate());

			List<Transaction> transactions = transactionRepository
					.findByFromAccountNumberOrToAccountNumber(accountNumber, accountNumber);
			if (transactions.size() >= 10)
				transactions = transactions.subList(transactions.size() - 10, transactions.size());

			// get the transaction data from account details
			transactions.stream().forEach(data -> {
				TransactionDto transactionDto = new TransactionDto();
				// Bind transaction data
				BeanUtils.copyProperties(data, transactionDto);

				if (data.getFromAccountNumber() == accountNumber)
					transactionDto.setTransactionType(ACCOUNT_TYPE_DEBIT);
				else
					transactionDto.setTransactionType(ACCOUNT_TYPE_CREDIT);
				transactionDtos.add(transactionDto);
			});
			accountDetailsDto.setTransactionSummary(transactionDtos);
			accountDetailsDto.setMessage(ACCOUNT_DETAILS_MESSAGE);
			accountDetailsDto.setStatusCode(HttpStatus.OK.value());
		} else {
			throw new AccountNotFoundException(ACCOUNT_NOT_EXCEPTION);
		}
		return accountDetailsDto;
	}
}