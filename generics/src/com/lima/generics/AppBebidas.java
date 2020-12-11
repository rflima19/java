package com.lima.generics;

import java.util.ArrayList;
import java.util.List;

public class AppBebidas {

	public static void main(String[] args) {
		
		List<Bebida> bebidas = new ArrayList<>();
		bebidas.add(new Cafe());
		bebidas.add(new Cha());
		bebidas.add(new Cha());
		
		AppBebidas.prepararBebidas(bebidas);
		
		List<Cafe> cafes = new ArrayList<>();
		cafes.add(new Cafe());
		cafes.add(new Cafe());

		AppBebidas.prepararBebidas(cafes);
		
		List<Cha> chas = new ArrayList<>();
		chas.add(new Cha());
		chas.add(new Cha());

		AppBebidas.prepararBebidas(chas);
		
		AppBebidas.prepararBebidas2(bebidas);
		AppBebidas.prepararBebidas2(cafes);
		// AppBebidas.prepararBebidas2(chas); // ERRO
		
		AppBebidas.prepararBebidas3(bebidas);
		AppBebidas.prepararBebidas3(cafes);
		AppBebidas.prepararBebidas3(chas);
	}
	
	public static void prepararBebidas(List<? extends Bebida> bebidas) {
		
		// bebidas.add(new Cafe()); // ERRO
		
		for (Bebida bebida : bebidas) {
			bebida.preparar();
		}
	}
	
	public static void prepararBebidas2(List<? super Cafe> bebidas) {
		
		bebidas.add(new Cafe());
		
		for (Object obj : bebidas) {
			Bebida bebida = (Bebida) obj;
			bebida.preparar();
		}
	}
	
	public static void prepararBebidas3(List<?> bebidas) {
		
		// bebidas.add(new Cafe()); // ERRO
		
		for (Object obj : bebidas) {
			// Bebida bebida = (Bebida) obj;
			// bebida.preparar();
			if (obj instanceof Cafe) {
				Cafe cafe = (Cafe) obj;
				cafe.preparar();
			} else if (obj instanceof Cha) {
				Cha cha = (Cha) obj;
				cha.preparar();
			}
			
		}
	}
}
