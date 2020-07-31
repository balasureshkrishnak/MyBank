package com.hcl.mybank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.mybank.config.ApplicationConstants;
import com.hcl.mybank.dto.TransactionRequestDto;
import com.hcl.mybank.dto.TransactionResponseDto;
import com.hcl.mybank.entity.Account;
import com.hcl.mybank.entity.Beneficiary;
import com.hcl.mybank.entity.Transaction;
import com.hcl.mybank.exception.DayLimitReachedException;
import com.hcl.mybank.exception.FromAccountNotFoundException;
import com.hcl.mybank.exception.NotValidBeneficiaryException;
import com.hcl.mybank.exception.ToAccountNotFoundException;
import com.hcl.mybank.repository.AccountRepository;
import com.hcl.mybank.repository.BeneficiaryRepository;
import com.hcl.mybank.repository.TransactionRepository;

/**
 * @author Bala Suresh Krishna. K
 * 31-07-2020
 * This is a transaction service implementation class
 */

@Service
public class TransactionServiceImpl implements TransactionService {

	private static Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	/**
	 * This api is to transfer the funds between two accounts
	 * 
	 * @param transactionRequestDto user need to input accountdetails and amount to
	 *                              transfer
	 * @return transactionResponseDto method should return whether transaction
	 *         succeeded or failed.
	 * 
	 */
	@Transactional
	public TransactionResponseDto fundTransfer(TransactionRequestDto transactionRequestDto)
			throws FromAccountNotFoundException, ToAccountNotFoundException, DayLimitReachedException,
			NotValidBeneficiaryException {
		logger.info("inside fund transfer method: ");
		TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
		String fromAcc = transactionRequestDto.getFromAccountNumber();
		String toAcc = transactionRequestDto.getToAccountNumber();
		Double transactionAmount = transactionRequestDto.getTransactionAmount();
		String comments = transactionRequestDto.getComments();
		Account fromAccount = null;
		Account toAccount = null;
		logger.info("getting from account details: ");
		Optional<Account> frmAccountNumber = accountRepository.findByAccountNumber(fromAcc);
		logger.info("checking whether from account exists or not");
		if (frmAccountNumber.isPresent()) {
			fromAccount = frmAccountNumber.get();
		} else {
			throw new FromAccountNotFoundException(ApplicationConstants.FROM_ACCOUNT_NOT_FOUND);
		}
		logger.info("checking whether to account exists or not");
		Optional<Account> toAccountNumber = accountRepository.findByAccountNumber(toAcc);
		if (toAccountNumber.isPresent()) {
			toAccount = toAccountNumber.get();
			Optional<Beneficiary> beneficiaries = beneficiaryRepository.findByAccountId(toAccount.getAccountId());
			if (beneficiaries.isPresent()) {
				Beneficiary beneficiary = beneficiaries.get();
				logger.info("checking for a valid beneficiary");
				if (beneficiary.getAccountId().equals(fromAccount.getAccountId())) {
					Double sourceBalance = fromAccount.getAvailableBalance();
					Double destinationBalance = toAccount.getAvailableBalance();
					if (sourceBalance < transactionAmount | transactionAmount < 0) {
						logger.info("transaction failed");
						transactionResponseDto.setStatusMessage(ApplicationConstants.TRANSACTION_FAILED);
						transactionResponseDto.setStatusCode(HttpStatus.OK.value());
						return transactionResponseDto;

					} else {

						Optional<List<Transaction>> transactions = transactionRepository
								.findByTransactionDate(LocalDate.now());
						List<Transaction> transactionList = transactions.get();
						Double amount = 0.0;
						for (Transaction transaction : transactionList) {
							amount = amount + transaction.getTransactionAmount();
						}
						if (fromAccount.getAccountType().equals("saving") & amount >= 50000
								| amount + transactionRequestDto.getTransactionAmount() >= 50000) {
							throw new DayLimitReachedException(ApplicationConstants.DAY_LIMIT_REACHED);
						}
						destinationBalance = destinationBalance + transactionAmount;
						fromAccount.setAvailableBalance(sourceBalance);
						accountRepository.save(fromAccount);
						toAccount.setAvailableBalance(destinationBalance);
						accountRepository.save(toAccount);
						Transaction transaction = new Transaction();
						transaction.setFromAccountNumber(fromAccount.getAccountNumber());
						transaction.setToAccountNumber(toAccount.getAccountNumber());
						transaction.setTransactionAmount(transactionAmount);
						transaction.setTransactionDate(LocalDate.now());
						transaction.setComments(comments);
						transactionRepository.save(transaction);
					}

				} else {
					throw new NotValidBeneficiaryException(ApplicationConstants.NOT_VALID_BENEFICIARY);
				}
			}

		} else {
			throw new ToAccountNotFoundException(ApplicationConstants.TO_ACCOUNT_NOT_FOUND);
		}
		return transactionResponseDto;
	}

}
