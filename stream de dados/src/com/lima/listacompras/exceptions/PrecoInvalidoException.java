package com.lima.listacompras.exceptions;

public class PrecoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	private double precoInvalido;

	public PrecoInvalidoException(double precoInvalido) {
		super();
		this.precoInvalido = precoInvalido;
	}

	public PrecoInvalidoException(double precoInvalido, String message, Throwable cause) {
		super(message, cause);
		this.precoInvalido = precoInvalido;
	}

	public PrecoInvalidoException(double precoInvalido, String message) {
		super(message);
		this.precoInvalido = precoInvalido;
	}

	public PrecoInvalidoException(double precoInvalido, Throwable cause) {
		super(cause);
		this.precoInvalido = precoInvalido;
	}
	
	public double getPrecoInvalido() {
		return precoInvalido;
	}
}
