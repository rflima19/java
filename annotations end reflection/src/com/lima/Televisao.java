package com.lima;

public class Televisao {

	private int canal;
	private boolean ligada;
	
	public Televisao() {
		System.out.println("Televisão criada");
	}
	
	public int getCanal() {
		return canal;
	}
	
	public boolean isLigada() {
		return ligada;
	}
	
	public void ligar() {
		this.ligada = true;
		System.out.println("Televisão ligada");
	}
	
	public void desligar() {
		this.ligada = false;
		System.out.println("Televisão desligada");
	}
	
	public void mudarCanal(int canal) {
		this.canal = canal;
		System.out.println("Canal mudado para canal " + canal);
	}
}
