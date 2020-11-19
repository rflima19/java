package com.lima.regex.jogodaforca.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lima.regex.jogodaforca.model.Palavra;
import com.lima.regex.jogodaforca.repository.Repository;
import com.lima.regex.jogodaforca.repository.RepositoryFile;
import com.lima.regex.jogodaforca.view.View;
import com.lima.regex.jogodaforca.view.ViewConsole;

public class ControllerConsole implements Controller {

	private final int MAX_TENTATIVAS = 6;
	private Repository repositorio;
	private View visao;
	
	public ControllerConsole() {
		super();
		this.visao = new ViewConsole();
		this.repositorio = new RepositoryFile();
	}

	@Override
	public void iniciarJogo() {
		int quantidadeErros = 0;
		String tema = this.visao.exibirSelecaoTema(this.repositorio.carregarTemas());
		List<Palavra> palavras = this.repositorio.carregarPalavras(tema);
		Palavra palavraSorteada = this.sotearPalavra(palavras);
		String mascara = palavraSorteada.getPalavra().replaceAll("[A-Za-z·‡‚„ÈËÍÌÔÛÙıˆ˙ÁÒ¡¿¬√…»Õœ”‘’÷⁄«—]", "_");
		
		boolean vitoria =false;
		Character caractere = ' ';
		while (quantidadeErros < this.MAX_TENTATIVAS) {
			if (mascara.equalsIgnoreCase(palavraSorteada.getPalavra())) {
				vitoria = true;
				break;
			}
			this.visao.exibirForca(quantidadeErros);
			this.visao.exibirPalavraOculta(tema, palavraSorteada.getQuantidadeLetras(), mascara);
			caractere = Character.valueOf(this.visao.exibirSelecaoCaractere());
			Set<Integer> indexs = this.verificarCaractere(caractere, palavraSorteada);
			if (indexs.size() > 0) {
				mascara = this.alterarMascara(caractere, mascara, indexs);
			} else {
				quantidadeErros++;
			}
		}
		if (vitoria == true) {
			this.visao.exibirMensagem(String.format("%n%s%n", "ParabÈns, vocÍ venceu o jogo"));
		} else {
			this.visao.exibirMensagem(String.format("%n%s%n", "VocÍ perdeu o jogo"));
		}
		this.visao.exibirForca(quantidadeErros);
		this.visao.exibirPalavraOculta(tema, palavraSorteada.getQuantidadeLetras(), palavraSorteada.getPalavra());
	}
	
	private String alterarMascara(Character caractere, String mascara, Set<Integer> indexs) {
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < mascara.length(); i++) {
			if (indexs.contains(Integer.valueOf(i))) {
				strb.append(caractere);
			} else {
				strb.append(mascara.charAt(i));
			}
		}
		return strb.toString();
	}
	
	private Set<Integer> verificarCaractere(Character caractere, Palavra palavra) {
		Pattern pattern = Pattern.compile(caractere.toString().toUpperCase());
		Matcher matcher = pattern.matcher(palavra.getPalavra().toUpperCase());
		Set<Integer> indexs = new HashSet<>();
		while (matcher.find()) {
			indexs.add(Integer.valueOf(matcher.start()));
		}
		return indexs;
	}
	
	private Palavra sotearPalavra(List<Palavra> palavras) {
		Random random = new Random();
		int index = random.nextInt(palavras.size());
		Palavra palavra = palavras.get(index);
		return palavra;
	}
}
