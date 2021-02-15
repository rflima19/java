package lima.com;

import java.util.concurrent.locks.ReentrantLock;

public class ContaBancaria {

	private double saldo;
	
	private ReentrantLock lock;

	public ContaBancaria(double saldo) {
		super();
		this.saldo = saldo;
		this.lock = new ReentrantLock(true);
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void sacar(double valor) {
		this.lock.lock();
		try {
			this.saldo -= valor;
		} finally {
			this.lock.unlock();
		}
		
	}
	
	public void depositar(double valor) {
		this.lock.lock();
		try {
			this.saldo += valor;
		} finally {
			this.lock.unlock();
		}
	}
}
