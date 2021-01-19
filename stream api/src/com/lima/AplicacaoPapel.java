package com.lima;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AplicacaoPapel {

	public static int cont = 0;
	
	public static void main(String[] args) {
		List<String> cores = Arrays.asList("Azul", "Branco", "Preto", "Preto", "Amarelo", "Azul");
		
		List<Papel> papeis = cores.stream()
				.map((String s) -> {
					Papel p = null;
					try {
						p = new Papel(++AplicacaoPapel.cont, Papel.Cor.valueOf(s.toUpperCase()));
					} catch (IllegalArgumentException e) {
						System.out.println("Argumento constante enum inexistente: " + s.toUpperCase());
					}
					return p;
				})
				.collect(Collectors.toList());
		
		papeis.stream().forEach(System.out::print);
	}
}
