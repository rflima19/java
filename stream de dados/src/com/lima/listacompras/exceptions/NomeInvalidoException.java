package com.lima.listacompras.exceptions;

public class NomeInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	private String nomeInvalido;

	public NomeInvalidoException(String nomeInvalido) {
		super();
		this.nomeInvalido = nomeInvalido;
	}

	public NomeInvalidoException(String nomeInvalido, String message, Throwable cause) {
		super(message, cause);
		this.nomeInvalido = nomeInvalido;
	}

	public NomeInvalidoException(String nomeInvalido, String message) {
		super(message);
		this.nomeInvalido = nomeInvalido;
	}

	public NomeInvalidoException(String nomeInvalido, Throwable cause) {
		super(cause);
		this.nomeInvalido = nomeInvalido;
	}
	
	public String getNomeInvalido() {
		return nomeInvalido;
	}
}
