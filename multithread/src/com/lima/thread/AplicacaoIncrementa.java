package com.lima.thread;

import java.util.Random;

public class AplicacaoIncrementa extends Thread {

	private Incrementador inc;

	public AplicacaoIncrementa(Incrementador inc) {
		super();
		this.inc = inc;
	}

	@Override
	public void run() {
		Random r = new Random();
		try {
			Thread.sleep(r.nextInt(10) * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.inc.incrementar();
	}

	public static void main(String[] args) {
		Incrementador inc = new Incrementador();
		AplicacaoIncrementa[] threadsInc = new AplicacaoIncrementa[100];

		for (int i = 0; i < threadsInc.length; i++) {
			threadsInc[i] = new AplicacaoIncrementa(inc);
		}
		
		for (int i = 0; i < threadsInc.length; i++) {
			threadsInc[i].start();
		}

		for (int i = 0; i < threadsInc.length; i++) {
			try {
				threadsInc[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Resultado final = " + inc.getCont());
	}
}
