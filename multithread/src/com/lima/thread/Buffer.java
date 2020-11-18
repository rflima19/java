package com.lima.thread;

public interface Buffer {

	public static final int TAMANHO_MAX_BUFFER = 10;
	
	public abstract void adicionar(int numero);
	
	public abstract int retirar();
	
	public abstract void imprimir();
	
}
