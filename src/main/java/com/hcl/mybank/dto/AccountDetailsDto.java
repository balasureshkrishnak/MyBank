package com.hcl.mybank.dto;

import java.util.ArrayList;
import java.util.List;

public class AccountDetailsDto {

	private String message;

	private Integer statusCode;

	private String accountNumber;

	private Double availableBalance;

	private String AccountCreationDate;

	List<TransactionDto> transactionSummary = new ArrayList();

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the availableBalance
	 */
	public Double getAvailableBalance() {
		return availableBalance;
	}

	/**
	 * @param availableBalance the availableBalance to set
	 */
	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

	/**
	 * @return the accountCreationDate
	 */
	public String getAccountCreationDate() {
		return AccountCreationDate;
	}

	/**
	 * @param accountCreationDate the accountCreationDate to set
	 */
	public void setAccountCreationDate(String accountCreationDate) {
		AccountCreationDate = accountCreationDate;
	}

	/**
	 * @return the transactionSummary
	 */
	public List<TransactionDto> getTransactionSummary() {
		return transactionSummary;
	}

	/**
	 * @param transactionSummary the transactionSummary to set
	 */
	public void setTransactionSummary(List<TransactionDto> transactionSummary) {
		this.transactionSummary = transactionSummary;
	}

	

}
