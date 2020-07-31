package com.hcl.mybank.exception;

public class DayLimitReachedException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public DayLimitReachedException(String message) {
		super(message);
	}

}
