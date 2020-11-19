package com.lima.regex.jogodaforca.model;

public class Palavra {

	private String palavra;
	private int quantidadeLetras;

	public Palavra(String palavra) {
		super();
		this.palavra = palavra;
		this.quantidadeLetras = 0;
		for (int i = 0; i < this.palavra.length(); i++) {
			if (Character.isLetter(this.palavra.charAt(i))) {
				this.quantidadeLetras++;
			}
		}
	}

	public String getPalavra() {
		return palavra;
	}

	public int getQuantidadeLetras() {
		return quantidadeLetras;
	}
}
