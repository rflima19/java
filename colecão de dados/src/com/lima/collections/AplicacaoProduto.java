package com.lima.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class AplicacaoProduto {

	public static void main(String[] args) {
		
		Produto p1 = new Produto("Laranja", 2.50);
		Produto p2 = new Produto("Laranja", 2.70);
		Produto p3 = new Produto("Maçã", 1.45);
		Produto p4 = new Produto("Mamão", 4.95);
		Produto p5 = new Produto("Limão", 2.30);
		
		//Produtos produtos = new Produtos(new ArrayList<>());
		//Produtos produtos = new Produtos(new HashSet<>());
		//Produtos produtos = new Produtos(new LinkedHashSet<>());
		Produtos produtos = new Produtos(new TreeSet<>());
		produtos.adicionar(p1);
		produtos.adicionar(p2);
		produtos.adicionar(p3);
		produtos.adicionar(p4);
		produtos.adicionar(p5);
		produtos.imprimir();
	}
}
