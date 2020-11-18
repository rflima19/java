package com.lima.thread.semaforo;

public enum Sinal {

	VERDE(1), VERMELHO(0);
	
	private int valor;
	
	private Sinal(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public static Sinal getSinal(int valor) {
		Sinal sinal = null;
		if (valor == 0) {
			sinal = Sinal.VERMELHO;
		} else if (valor == 1) {
			sinal = Sinal.VERDE;
		}
		return sinal;
	}
}
