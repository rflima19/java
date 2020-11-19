package com.lima.regex.jogodaforca.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ViewConsole implements View {

	private Scanner input;

	public ViewConsole() {
		super();
		this.input = new Scanner(System.in);
	}

	@Override
	public String exibirSelecaoTema(String[] temas) {
		this.imprimirTitulo();

		int opcao = -1;
		System.out.println("Selecione o tema do jogo (digite o número correspondente a opção desejada):");
		for (int i = 0; i < temas.length; i++) {
			System.out.println(i + " - " + temas[i]);
		}

		while ((opcao < 0) || (opcao > (temas.length - 1))) {
			try {
				System.out.print(">>");
				opcao = Integer.valueOf(this.input.next());
			} catch (NumberFormatException e) {
				System.out.println("Opção inválida.");
			}
		}

		return temas[opcao];
	}

	@Override
	public char exibirSelecaoCaractere() {
		System.out.println("Digite uma letra:");
		String caractere = null;
		while (true) {
			System.out.print(">>");
			caractere = this.input.next();
			if ((caractere.isEmpty()) || (caractere.length() > 2)
					|| Pattern.matches("[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]", caractere) == false) {
				System.out.println("entrada inválida.");
				continue;
			} else {
				break;
			}
		}
		return caractere.charAt(0);
	}

	@Override
	public void exibirForca(int quantidadeErros) {
		String cabeca = (quantidadeErros >= 1) ? "O" : "";
		String bracoDiretiro = (quantidadeErros >= 2) ? "---|" : "";
		String bracoEsquerdo = (quantidadeErros >= 3) ? "---" : "";
		String troco = (quantidadeErros >= 4) ? "|" : "";
		String pernaDireita = (quantidadeErros >= 5) ? "/" : "";
		String pernaEsquerda = (quantidadeErros >= 6) ? "\\" : "";

		System.out.println("__________________");
		System.out.println("|                |");
		System.out.println("|                |");
		System.out.println("|                " + cabeca);
		System.out.println("|             " + bracoDiretiro + bracoEsquerdo);
		System.out.println("|                " + troco);
		System.out.println("|               " + pernaDireita + " " + pernaEsquerda);
		System.out.println("|              " + pernaDireita + "   " + pernaEsquerda);
		System.out.println("|                 ");
		System.out.println("|                 ");
		System.out.println("|                 \n");
	}

	@Override
	public void exibirPalavraOculta(String tema, int quantidadeLetras, String mascara) {
		System.out.println("Palavra com " + quantidadeLetras + " letras no tema " + tema);
		char[] array = mascara.toCharArray();
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + Character.toUpperCase(array[i]) + " ");
		}
		System.out.printf("%n%n");
	}

	@Override
	public void exibirMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	private void imprimirTitulo() {
		int aux = 20;
		for (int i = 0; i < aux; i++) {
			System.out.print("-");
		}
		System.out.print(" JOGO DA FORCA ");
		for (int i = 0; i < aux; i++) {
			System.out.print("-");
		}
		System.out.printf("%n%n");
	}

}
