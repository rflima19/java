package com.lima.thread.semaforo;

import java.util.Random;

public class Carro extends Thread {

	private int placa;
	private Semaforo semaforo;

	public Carro(int placa, Semaforo semaforo) {
		super();
		this.placa = placa;
		this.semaforo = semaforo;
	}
	
	public int getPlaca() {
		return placa;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		while (true) {
			this.semaforo.atravessar(this);
			
			try {
				Thread.sleep(random.nextInt(10) * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
