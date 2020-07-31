package com.hcl.mybank.exception;

public class NotValidBeneficiaryException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public NotValidBeneficiaryException(String message) {
		super(message);
	}

}
