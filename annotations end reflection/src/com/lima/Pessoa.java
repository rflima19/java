package com.lima;

public class Pessoa {

	private String nome;
	private Integer idade;

	public Pessoa() {
		super();
		this.nome = "";
		this.idade = Integer.valueOf(0);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return String.format("[nome=%s, idade=%d]%n", this.nome, this.idade.intValue());
	}
}
