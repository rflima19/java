package com.lima.thread;

public class BufferFilaArray implements Buffer {

	//public static final int TAMANHO_MAX_BUFFER = 10;
	
	private Integer[] arrayBuffer;
	private int quantidade;

	public BufferFilaArray() {
		super();
		this.arrayBuffer = new Integer[BufferFilaArray.TAMANHO_MAX_BUFFER];
		this.quantidade = 0;
	}
	
	public synchronized void adicionar(int numero) {
		while (this.quantidade == BufferFilaArray.TAMANHO_MAX_BUFFER) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < this.arrayBuffer.length; i++) {
			if (this.arrayBuffer[i] == null) {
				this.arrayBuffer[i] = Integer.valueOf(numero);
				break;
			}
		}
		
		++this.quantidade;
		
		this.imprimir();
		
		this.notifyAll();
	}
	
	public synchronized int retirar() {
		while (this.quantidade == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int numero = this.arrayBuffer[0].intValue();
		
		for (int i = 0; i < this.arrayBuffer.length; i++) {
			if (i == (BufferFila.TAMANHO_MAX_BUFFER - 1)) {
				this.arrayBuffer[BufferFilaArray.TAMANHO_MAX_BUFFER - 1] = null;
				break;
			}
			if (this.arrayBuffer[i + 1] == null) {
				this.arrayBuffer[i] = null;
				break;
			}
			this.arrayBuffer[i] = this.arrayBuffer[i + 1];
		}
		
		--this.quantidade;
		
		this.imprimir();
		
		this.notifyAll();
		
		
		return numero;
	}
	
	public synchronized void imprimir() {
		Integer numero = null;
		System.out.printf("%-12s -> buffer[%02d] ", Thread.currentThread().getName(), this.quantidade);
		for (int i = 0; i < this.arrayBuffer.length; i++) {
			numero = this.arrayBuffer[i];
			if (numero != null) {
				System.out.printf("%02d ", numero);
			}
		}
		System.out.printf("%n");
	}
}
