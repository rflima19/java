package com.lima.regex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Album {

	private List<Foto> fotos;
	
	public Album() {
		super();
		this.fotos = new ArrayList<>();
	}
	
	public void adicionar(int id, LocalDate data, String local) {
		Foto foto = new Foto(id, data, local);
		this.fotos.add(foto);
	}
	
	public void listarFotos() {
		Iterator<Foto> iterator = this.fotos.iterator();
		while (iterator.hasNext()) {
			Foto foto = iterator.next();
			System.out.println(foto.toString());
		}
	}
}
