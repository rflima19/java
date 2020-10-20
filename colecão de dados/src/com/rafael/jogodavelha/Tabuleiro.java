package com.rafael.jogodavelha;

import java.util.Arrays;

public class Tabuleiro {
	
	private final char[][] tabuleiro = new char[3][3];
	private final String separadorLinha = " | ";
	private final String separadorColuna = "----------";
	
	public static final int TAMANHO_LINHA = 3;
	public static final int TAMANHO_COLUNA = 3;
	
	public Tabuleiro() {
		super();
	}
	
	public void iniciar() {
		Arrays.fill(this.tabuleiro[0], ' ');
		Arrays.fill(this.tabuleiro[1], ' ');
		Arrays.fill(this.tabuleiro[2], ' ');
	}
	
	public void imprimir() {
		System.out.println();
		for (int i = 0; i < this.tabuleiro.length; i++) {
			for (int j = 0; j < this.tabuleiro[i].length; j++) {
				if (j != 0) {
					System.out.printf("%s", this.separadorLinha);
				}
				System.out.printf("%c", this.tabuleiro[i][j]);
			}
			if (i != this.tabuleiro.length - 1) {
				System.out.printf("%n%s%n", this.separadorColuna);
			}
		}
		System.out.println();
		System.out.println();
	}
	
	public void inserirJogada(Jogada jogada) {
		int linha = jogada.getLinha() - 1;
		int coluna = jogada.getColuna() - 1;
		this.tabuleiro[linha][coluna] = jogada.getJogador().getSimbolo().name().charAt(0);
	}
	
	public boolean verificarTabuleiroFimJogo() {
		// verifica horizontal
		if (this.tabuleiro[0][0] == this.tabuleiro[0][1] && 
				this.tabuleiro[0][1] == this.tabuleiro[0][2] &&
				this.tabuleiro[0][0] != ' ') {
			return true;
		}
		if (this.tabuleiro[1][0] == this.tabuleiro[1][1] && 
				this.tabuleiro[1][1] == this.tabuleiro[1][2] &&
				this.tabuleiro[1][0] != ' ') {
			return true;
		}
		if (this.tabuleiro[2][0] == this.tabuleiro[2][1] && 
				this.tabuleiro[2][1] == this.tabuleiro[2][2] &&
				this.tabuleiro[2][0] != ' ') {
			return true;
		}

		// verifica vertical
		if (this.tabuleiro[0][0] == this.tabuleiro[1][0] && 
				this.tabuleiro[1][0] == this.tabuleiro[2][0] &&
				this.tabuleiro[0][0] != ' ') {
			return true;
		}
		if (this.tabuleiro[0][1] == this.tabuleiro[1][1] && 
				this.tabuleiro[1][1] == this.tabuleiro[2][1] &&
				this.tabuleiro[0][1] != ' ') {
			return true;
		}
		if (this.tabuleiro[0][2] == this.tabuleiro[1][2] && 
				this.tabuleiro[1][2] == this.tabuleiro[2][2] &&
				this.tabuleiro[0][2] != ' ') {
			return true;
		}
		
		// verifica diagonal
		if (this.tabuleiro[0][0] == this.tabuleiro[1][1] && 
				this.tabuleiro[1][1] == this.tabuleiro[2][2] &&
				this.tabuleiro[0][0] != ' ') {
			return true;
		}
		if (this.tabuleiro[2][0] == this.tabuleiro[1][1] && 
				this.tabuleiro[1][1] == this.tabuleiro[0][2] &&
				this.tabuleiro[2][0] != ' ') {
			return true;
		}
		
		return false;
	}
	
	public boolean verificarTabuleiroCheio() {
		for (int i = 0; i < this.tabuleiro.length; i++) {
			for (int j = 0; j < this.tabuleiro[i].length; j++) {
				if (this.tabuleiro[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}
