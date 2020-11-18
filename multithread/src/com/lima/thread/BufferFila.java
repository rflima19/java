package com.lima.thread;

import java.util.LinkedList;
import java.util.Queue;

public class BufferFila implements Buffer {

	//public static final int TAMANHO_MAX_BUFFER = 10;
	
	private Queue<Integer> filaBuffer;

	public BufferFila() {
		super();
		this.filaBuffer = new LinkedList<>();
	}
	
	public synchronized void adicionar(int numero) {
		while (this.filaBuffer.size() == BufferFila.TAMANHO_MAX_BUFFER) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.filaBuffer.offer(Integer.valueOf(numero));
		
		this.imprimir();
		
		this.notifyAll();
	}
	
	public synchronized int retirar() {
		while (this.filaBuffer.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int numero = this.filaBuffer.poll();
		
		this.imprimir();
		
		this.notifyAll();
		
		return numero;
	}
	
	public synchronized void imprimir() {
		System.out.printf("%-12s -> buffer[%02d] ", Thread.currentThread().getName(), this.filaBuffer.size());
		for (Integer integer : filaBuffer) {
			System.out.printf("%02d ", integer.intValue());
		}
		System.out.printf("%n");
	}
}
