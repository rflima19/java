package com.lima.collections;

public abstract class Colecao {

	protected Object[] array;

	public Colecao() {
		super();
		this.array = new Object[10];
	}
	
	public Colecao(int tamanho) {
		super();
		this.array = new Object[tamanho];
	}
	
	public Colecao(Object[] array) {
		super();
		this.array = array;
	}
	
	public abstract void inserirItem(Object item);

	public abstract Object removerItem();
}
