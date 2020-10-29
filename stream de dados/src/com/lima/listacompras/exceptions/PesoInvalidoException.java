package com.lima.listacompras.exceptions;

public class PesoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	private double pesoInvalido;

	public PesoInvalidoException(double pesoInvalido) {
		super();
		this.pesoInvalido = pesoInvalido;
	}

	public PesoInvalidoException(double pesoInvalido, String message, Throwable cause) {
		super(message, cause);
		this.pesoInvalido = pesoInvalido;
	}

	public PesoInvalidoException(double pesoInvalido, String message) {
		super(message);
		this.pesoInvalido = pesoInvalido;
	}

	public PesoInvalidoException(double pesoInvalido, Throwable cause) {
		super(cause);
		this.pesoInvalido = pesoInvalido;
	}
	
	public double getPesoInvalido() {
		return pesoInvalido;
	}
}
