package com.lima.thread.corridasapos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Corrida {

	private int distancia;
	private List<Sapo> ranking;
	
	public Corrida(int distancia) {
		super();
		this.distancia = distancia;
		this.ranking = new ArrayList<>();
	}
	
	public int getDistancia() {
		return this.distancia;
	}
	
	public synchronized void adicionarSapoRanking(Sapo sapo) {
		this.ranking.add(sapo);
	}
	
	public synchronized void imprimirResultado() {
		int colocacao = 0;
		Iterator<Sapo> iterator = this.ranking.iterator();
		while (iterator.hasNext()) {
			System.out.println(++colocacao + "º -> " + iterator.next().getNome());
		}
	}
	
	public synchronized void reiniciarCorrida() {
		this.ranking.clear();
	}
}
