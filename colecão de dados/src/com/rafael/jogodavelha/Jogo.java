package com.rafael.jogodavelha;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.rafael.jogodavelha.exceptions.JogadaInvalidaException;
import com.rafael.jogodavelha.utils.Console;

public class Jogo {

	private final int quantidadeJogadores = 2;
	private Set<Jogada> jogadas;
	private Jogador[] jogadores;
	private boolean continuaJogo;

	public Jogo() {
		this.jogadas = new LinkedHashSet<>();
		this.jogadores = new Jogador[this.quantidadeJogadores];
		this.continuaJogo = true;
	}

	public Jogador[] getJogadores() {
		return jogadores;
	}

	public Set<Jogada> getJogadas() {
		return jogadas;
	}

	public boolean isContinua() {
		return continuaJogo;
	}

	public void setContinua(boolean continua) {
		this.continuaJogo = continua;
	}

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		Tabuleiro tabuleiro = new Tabuleiro();
		Jogador jogadorAtual = null;
		Jogada jogadaAtual = null;
		int continuaJogo = 0;
		int indexJogador = 0;

		try {
			do {
				jogo.obterJogadores(jogo.jogadores);

				jogadorAtual = jogo.jogadores[indexJogador];
				tabuleiro.iniciar();
				jogo.jogadas.clear();

				while (true) {
					tabuleiro.imprimir();
					System.out.printf("Vez do jogador %s jogar (Símbolo %s)", jogadorAtual.getNome(), jogadorAtual.getSimbolo().name());
					jogadaAtual = jogadorAtual.realizarJogada();
					try {
						Jogada.validarJogada(jogadaAtual);
					} catch (JogadaInvalidaException e) {
						System.out.printf("%nJogada na linha %02d e coluna %02d é inválida. " +
								"Tente outra jogada.%n", jogadaAtual.getLinha(), jogadaAtual.getColuna());
						continue;
					}
					if (!jogo.jogadas.add(jogadaAtual)) {
						System.out.printf("%nJogada na posição linha %02d e coluna %02d já foi realizada anteriormente. " +
								"Tente outra jogada.%n", jogadaAtual.getLinha(), jogadaAtual.getColuna());
						continue;
					}

					tabuleiro.inserirJogada(jogadaAtual);
					
					if (tabuleiro.verificarTabuleiroFimJogo()) {
						tabuleiro.imprimir();
						System.out.printf("%nFim de jogo%n");
						System.out.printf("Vencendor do jogo foi %s%n%n", jogadorAtual.getNome());
						break;
					} else if (tabuleiro.verificarTabuleiroCheio()) {
						tabuleiro.imprimir();
						System.out.printf("%nFim de jogo%n");
						System.out.printf("O jogo terminou empate%n%n");
						break;
					} else {
						indexJogador = (indexJogador + 1) % jogo.quantidadeJogadores;
						jogadorAtual = jogo.jogadores[indexJogador];
					}
				}

				try {
					System.out.printf("Para continua jogo digite 1, ou qualquer outra tecla para sair.%n");
					continuaJogo = Console.readInt();
					if (continuaJogo != 1) {
						jogo.setContinua(false);
					} else {
						indexJogador = 0;
					}
				} catch (NumberFormatException e) {
					jogo.setContinua(false);
				}
			} while (jogo.isContinua() == true);
		} catch (IOException e) {
			System.err.println("Erro de leitura do console");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("O programa esperava um inteiro válido");
			e.printStackTrace();
		}
	}

	public void obterJogadores(Jogador[] array) throws IOException {
		Jogador j1 = null;
		Jogador j2 = null;
		String nome;

		System.out.printf("Digite o nome do 1ª jogador (Símbolo %s): ", Simbolo.X.name());
		nome = Console.readString();
		j1 = new Jogador(nome, Simbolo.X);

		System.out.printf("Digite o nome do 2ª jogador (Símbolo %s): ", Simbolo.O.name());
		nome = Console.readString();
		j2 = new Jogador(nome, Simbolo.O);

		array[0] = j1;
		array[1] = j2;
	}
}
