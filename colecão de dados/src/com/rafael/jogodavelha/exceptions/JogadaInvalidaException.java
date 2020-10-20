package com.rafael.jogodavelha.exceptions;

public class JogadaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;
	private int linha;
	private int coluna;

	public JogadaInvalidaException(String message, Throwable cause, int linha, int coluna) {
		super(message, cause);
		this.linha = linha;
		this.coluna = coluna;
	}

	public JogadaInvalidaException(String message, int linha, int coluna) {
		super(message);
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
}
