package com.lima.regex.jogodaforca.view;

public interface View {

	public abstract String exibirSelecaoTema(String[] temas);
	
	public abstract char exibirSelecaoCaractere();
	
	public abstract void exibirForca(int quantidadeErros);
	
	public abstract void exibirPalavraOculta(String tema, int quantidadeLetras, String mascara);
	
	public abstract void exibirMensagem(String mensagem);
}
