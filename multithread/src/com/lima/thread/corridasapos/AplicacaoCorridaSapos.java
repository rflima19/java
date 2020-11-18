package com.lima.thread.corridasapos;

public class AplicacaoCorridaSapos {

	public static void main(String[] args) {
		Corrida corrida = new Corrida(1000);
		
		Sapo[] sapos = new Sapo[10];
		
		for (int i = 0; i < sapos.length; i++) {
			sapos[i] = new Sapo("Sapo" + i, corrida);
		}
		
		for (int i = 0; i < sapos.length; i++) {
			sapos[i].start();
		}
		
		for (int i = 0; i < sapos.length; i++) {
			try {
				sapos[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("RESULTADO CORRIDA:");
		corrida.imprimirResultado();
	}
}
