package com.fpedro.cursomc.services.exception;

public class DateIntegrityException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DateIntegrityException(String msg) {
		super(msg);
	}
	public DateIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
