package com.lima.collections;

import java.util.Collection;
import java.util.Iterator;

public class Produtos {
	
	private Collection<Produto> produtos;

	public Produtos(Collection<Produto> produtos) {
		super();
		this.produtos = produtos;
	}
	
	public void adicionar(Produto p) {
		this.produtos.add(p);
	}
	
	public void imprimir() {
		Iterator<Produto> itarator = this.produtos.iterator();
		while (itarator.hasNext()) {
			System.out.println(itarator.next().toString());
		}
	}

}
