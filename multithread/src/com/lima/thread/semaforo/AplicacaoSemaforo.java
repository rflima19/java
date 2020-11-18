package com.lima.thread.semaforo;

public class AplicacaoSemaforo {

	public static void main(String[] args) {
		Semaforo semaforo = new Semaforo(Sinal.VERMELHO);
		Carro[] carros = new Carro[10];
		
		semaforo.start();
		for (int i = 0; i < carros.length; i++) {
			carros[i] = new Carro(i, semaforo);
			carros[i].start();
		}
	}
}
