package com.lima.regex;

import java.io.File;

public class AplicacaoOrganizadorFoto {

	public static void main(String[] args) {
		String homeUser = System.getProperty("user.home");
		String separador = System.getProperty("file.separator");
		File diretorio = new File(homeUser + separador + "fotos");
		
		try {
			Organizador org = new Organizador();
			Album album = org.carregarFotos(diretorio);
			album.listarFotos();
		} catch (DiretorioInvalido e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
