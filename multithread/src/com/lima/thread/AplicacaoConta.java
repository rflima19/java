package com.lima.thread;

public class AplicacaoConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta(1000.0);
		Thread[] threads = new Thread[5];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Usuario(conta), "Usuario[" + i + "]");
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				System.out.println("Espera interrompida.");
				e.printStackTrace();
			}
		}
		
		System.out.println("Saldo final: " + conta.getSaldo());
	}
}
