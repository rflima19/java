package com.lima.listacompras.exceptions;

import java.io.File;

public class ArquivoVazioException extends Exception {

	private static final long serialVersionUID = 1L;
	private File arquivo;

	public ArquivoVazioException(String message, File arquivo, Throwable cause) {
		super(message, cause);
		this.arquivo = arquivo;
	}

	public ArquivoVazioException(String message, File arquivo) {
		super(message);
		this.arquivo = arquivo;
	}
	
	public File getArquivo() {
		return arquivo;
	}
}
