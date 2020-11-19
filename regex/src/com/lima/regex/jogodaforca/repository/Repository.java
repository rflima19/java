package com.lima.regex.jogodaforca.repository;

import java.util.List;

import com.lima.regex.jogodaforca.model.Palavra;

public interface Repository {

	public abstract List<Palavra> carregarPalavras(String nomeArquivo);
	
	public abstract String[] carregarTemas();
}
