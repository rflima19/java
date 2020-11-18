package com.lima.thread;

public class Incrementador {

	private int cont;
	private Object lock;

	public Incrementador() {
		super();
		this.cont = 0;
		this.lock = new Object();
	}

	public int getCont() {
		synchronized (this.lock) {
			return cont;
		}
	}
	
	public void incrementar() {
		synchronized (this.lock) {
			++this.cont;
		}
	}
	
}
