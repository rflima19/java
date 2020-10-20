package com.rafael.jogodavelha;

import java.io.IOException;

import com.rafael.jogodavelha.utils.Console;

public class Jogador {

	private String nome;
	private Simbolo simbolo;

	public Jogador(String nome, Simbolo simbolo) {
		super();
		this.nome = nome;
		this.simbolo = simbolo;
	}

	public String getNome() {
		return nome;
	}
	
	public Simbolo getSimbolo() {
		return simbolo;
	}
	
	public Jogada realizarJogada() throws NumberFormatException, IOException {
		int linha = -1;
		int coluna = -1;
		
		System.out.printf("%nDigite a linha: ");
		linha = Console.readInt();
		
		System.out.printf("%nDigite a coluna: ");
		coluna = Console.readInt();
		
		Jogada jogada = new Jogada(this, linha, coluna);
		
		return jogada;
	}
	
	@Override
	public String toString() {
		return "[nome:" + this.nome + ", símbolo:" + this.simbolo.name() + "]";
	}
}
