package com.lima.thread.corridasapos;

public class Sapo extends Thread {

	private String nome;
	private int distanciaPercorrida;
	private Corrida corrida;
	
	public Sapo(String nome, Corrida corrida) {
		super();
		this.nome = nome;
		this.distanciaPercorrida = 0;
		this.corrida = corrida;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void pular() {
		int distanciaPulo = this.gerarNumeroRandomico(10, 50);
		this.distanciaPercorrida += distanciaPulo;
		if (this.distanciaPercorrida > this.corrida.getDistancia()) {
			this.distanciaPercorrida = this.corrida.getDistancia();
		}
		System.out.println("Sapo " + this.nome + " já percorreu " + this.distanciaPercorrida + " de " + this.corrida.getDistancia() + ".");
	}
	
	public void descansar() {
		try {
			System.out.println("Sapo " + this.nome + " parrou para descansar.");
			Thread.sleep(this.gerarNumeroRandomico(1, 3) * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private int gerarNumeroRandomico(int inicio, int fim) {
		int intervalo = fim - inicio;
		int numero = (int) (Math.random() * intervalo) + inicio;
		return numero;
	}
	
	@Override
	public void run() {
		while (true) {
			this.pular();
			
			if (this.distanciaPercorrida >= corrida.getDistancia()) {
				System.out.println("Sapo " + this.nome + " terminou a corrida.");
				this.corrida.adicionarSapoRanking(this);
				return;
			} else {
				this.descansar();
			}
		}
	}
}
