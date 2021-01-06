package com.lima;

public class Televisao {

	private int canal;
	private boolean ligada;
	
	public Televisao() {
		System.out.println("Televis�o criada");
	}
	
	public int getCanal() {
		return canal;
	}
	
	public boolean isLigada() {
		return ligada;
	}
	
	public void ligar() {
		this.ligada = true;
		System.out.println("Televis�o ligada");
	}
	
	public void desligar() {
		this.ligada = false;
		System.out.println("Televis�o desligada");
	}
	
	public void mudarCanal(int canal) {
		this.canal = canal;
		System.out.println("Canal mudado para canal " + canal);
	}
}
