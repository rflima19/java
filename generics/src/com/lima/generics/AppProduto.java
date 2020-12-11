package com.lima.generics;

import java.time.LocalDate;

public class AppProduto {

	public static void main(String[] args) {
		Produto<String> p1 = new Produto<String>("AC347", "Peça mecanica", 1000.0);
		System.out.println(p1);
		
		Produto<Codigo<String, Integer>> p2 = new Produto<>(new Codigo("RF", 4501), "Roupa masculina", 450.0);
		System.out.println(p2);
		
		Produto<Codigo<String, LocalDate>> p3 = new Produto<>(new Codigo("Nac", LocalDate.now()), "Computador", 1200.0);
		System.out.println(p3);
		
		Produto<Codigo<String, String>> p4 = new Produto<>(new Codigo("TQjpU", 4501), "Microondas", 500.0);
		System.out.println(p4);
	}
}
