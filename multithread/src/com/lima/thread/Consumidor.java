package com.lima.thread;

import java.util.Random;

public class Consumidor implements Runnable {

	private Buffer buffer;
	private Random random;

	public Consumidor(Buffer buffer) {
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
			
			numero = this.buffer.retirar();
		}
	}
}
