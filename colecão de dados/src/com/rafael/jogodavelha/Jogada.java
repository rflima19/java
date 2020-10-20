package com.rafael.jogodavelha;

import com.rafael.jogodavelha.exceptions.JogadaInvalidaException;

public class Jogada {

	private Jogador jogador;
	private int linha;
	private int coluna;

	public Jogada(Jogador jogador, int linha, int coluna) {
		super();
		this.jogador = jogador;
		this.linha = linha;
		this.coluna = coluna;
	}

	public Jogador getJogador() {
		return jogador;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}

	public static void validarJogada(Jogada jogada) throws JogadaInvalidaException {
		if (jogada.getLinha() > Tabuleiro.TAMANHO_LINHA ||
				jogada.getColuna() > Tabuleiro.TAMANHO_COLUNA) {
			throw new JogadaInvalidaException("Jogada Inválida", jogada.getLinha(), jogada.getColuna());
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coluna;
		result = prime * result + linha;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogada other = (Jogada) obj;
		if (coluna != other.coluna)
			return false;
		if (linha != other.linha)
			return false;
		return true;
	}
}
