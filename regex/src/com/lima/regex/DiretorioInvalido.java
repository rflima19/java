package com.lima.regex;

import java.io.File;

public class DiretorioInvalido extends Exception {

	private File path;

	public DiretorioInvalido(File path, String message) {
		super(message);
		this.path = path;
	}
	
	public File getPath() {
		return path;
	}
}
