package com.lima.listacompras.exceptions;

public class CompraInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public CompraInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CompraInvalidaException(String message) {
		super(message);
	}
	
	
}
