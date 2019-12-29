package com.mateus.sistema.services.exceptions;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BusinessException (String msg) {
		super(msg);
	}
	
	public BusinessException(String msg, Throwable causa) {
		super(msg, causa);
	}
}
