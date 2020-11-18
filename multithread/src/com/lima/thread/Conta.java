package com.lima.thread;

public class Conta {

	private double saldo;

	public Conta(double saldo) {
		super();
		this.saldo = saldo;
	}
	
	public synchronized double getSaldo() {
		return saldo;
	}
	
	public synchronized void depositar(double valor) {
//		if (valor < 1.0) {
//			return;
//		}
		
		this.saldo += valor;
		
		System.out.println(Thread.currentThread().getName() + ": deposita " + valor + " -> saldo = " + this.saldo);
	}
	
	public synchronized void sacar(double valor) {
//		if (valor > this.saldo) {
//			return;
//		}
		
		this.saldo -= valor;
		
		System.out.println(Thread.currentThread().getName() + ": saca " + valor + " -> saldo = " + this.saldo);
	}
}
