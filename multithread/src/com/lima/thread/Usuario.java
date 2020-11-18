package com.lima.thread;

import java.util.Random;

public class Usuario implements Runnable {

	private Conta conta;

	public Usuario(Conta conta) {
		super();
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			this.conta.depositar(100.0);
			
			try {
				Thread.sleep(random.nextInt(10) * 100);
			} catch (InterruptedException e) {
				System.out.println("Espera interrompida.");
				e.printStackTrace();
			}
			
			this.conta.sacar(100.0);
		}
	}
}
