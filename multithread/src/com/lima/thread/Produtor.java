package com.lima.thread;

import java.util.Random;

public class Produtor implements Runnable {

	private Buffer buffer;
	private Random random;

	public Produtor(Buffer buffer) {
		super();
		this.buffer = buffer;
		this.random = new Random();
	}
	
	@Override
	public void run() {
		int numero = 0;
		while (true) {
			try {
				Thread.sleep(this.random.nextInt(10) * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			numero = this.gerarNumeroInteiro(1, 100);
			this.buffer.adicionar(numero);
		}
	}
	
	private int gerarNumeroInteiro(int inicio, int fim) {
		int intervalo = fim - inicio;
		int numero = ((int) (Math.random() * intervalo)) + inicio;
		return numero;
	}
}
