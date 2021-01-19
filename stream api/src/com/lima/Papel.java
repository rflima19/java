package com.lima;

public class Papel {

	public enum Cor {
		BRANCO, PRETO, AZUL, VERMELHO, AMARELO;
	}

	private int id;
	private Cor cor;

	public Papel(int id, Cor cor) {
		super();
		this.id = id;
		this.cor = cor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return String.format("%d - %s%n", this.id, this.cor);
	}
}
