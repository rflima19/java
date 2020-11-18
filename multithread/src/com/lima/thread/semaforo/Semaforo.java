package com.lima.thread.semaforo;

public class Semaforo extends Thread {

	public static final int TEMPO_SEMAFORO = 3000;
	
	private Sinal luz;

	public Semaforo(Sinal luz) {
		super();
		this.luz = luz;
	}
	
	public synchronized void atravessar(Carro carro) {
		while (this.luz == Sinal.VERMELHO) {
			try {
				System.out.println("Carro " + carro.getPlaca() + " parrou no sem�foro.");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Carro " + carro.getPlaca() + " atravessou sem�foro.");
	}
	
	public synchronized void mudarSinal() {
		this.luz = Sinal.getSinal((this.luz.getValor() + 1) % Sinal.values().length);
		if (this.luz.equals(Sinal.VERMELHO)) {
			System.out.println("Sem�foro fechado.");
		} else if (this.luz.equals(Sinal.VERDE)) {
			System.out.println("Sem�foro aberto.");
			this.notifyAll();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(Semaforo.TEMPO_SEMAFORO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.mudarSinal();
		}
	}
}
