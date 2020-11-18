package com.lima.thread;

import java.util.Random;

public class Filosofo extends Thread {

	private MesaJantar mesa;
	private int numero;
	private int tentativasComer;
	private SituacaoFilosofo situacao;
	
	public Filosofo(MesaJantar mesa, String name, int numero) {
		super(name);
		this.numero = numero;
		this.mesa = mesa;
		this.tentativasComer = 0;
		this.situacao = SituacaoFilosofo.PENSANDO;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public int getTentativasComer() {
		return tentativasComer;
	}
	
	public void setTentativasComer(int tentativasComer) {
		this.tentativasComer = tentativasComer;
	}
	
	public SituacaoFilosofo getSituacao() {
		return situacao;
	}
	
	public void setSituacao(SituacaoFilosofo situacao) {
		this.situacao = situacao;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		while (true) {
			this.mesa.pegarGarfos(this);
			
			try {
				Thread.sleep(random.nextInt(3) * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.mesa.devolverGarfos(this);
			
			try {
				Thread.sleep(random.nextInt(5) * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
