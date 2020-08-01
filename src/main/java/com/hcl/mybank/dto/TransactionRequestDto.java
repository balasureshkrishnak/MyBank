package com.hcl.mybank.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransactionRequestDto {
	
	@NotNull(message = "Name may not be null")
	@NotEmpty(message = "Name may not be empty")
	private String fromAccountNumber;
	
	@NotNull(message = "Name may not be null")
	@NotEmpty(message = "Name may not be empty")
	private String toAccountNumber;
		
	@NotNull(message = "Name may not be null")
	@NotEmpty(message = "Name may not be empty")
	private Double transactionAmount;
		
	@NotNull(message = "Name may not be null")
	@NotEmpty(message = "Name may not be empty")
	private String comments;

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
