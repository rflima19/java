package com.lima.listacompras.exceptions;

public class QuantidadeInvalidaException extends Exception {

	private double quantidadeInvalida;

	public QuantidadeInvalidaException(double quantidadeInvalida) {
		super();
		this.quantidadeInvalida = quantidadeInvalida;
	}

	public QuantidadeInvalidaException(double quantidadeInvalida, String message, Throwable cause) {
		super(message, cause);
		this.quantidadeInvalida = quantidadeInvalida;
	}

	public QuantidadeInvalidaException(double quantidadeInvalida, String message) {
		super(message);
		this.quantidadeInvalida = quantidadeInvalida;
	}

	public QuantidadeInvalidaException(double quantidadeInvalida, Throwable cause) {
		super(cause);
		this.quantidadeInvalida = quantidadeInvalida;
	}
	
	public double getQuantidadeInvalida() {
		return quantidadeInvalida;
	}
}
