package com.lima.regex;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Organizador {

	private Pattern pattern;
	private Scanner scanner;

	public Organizador() {
		super();
		this.pattern = Pattern.compile("^IMG\\d{5}-\\d{8}(_.+)?.jpg$");
		this.scanner = null;
	}

	public Album carregarFotos(File diretorio) throws DiretorioInvalido {
		if ((diretorio.exists() == false) || (diretorio.isFile() == true)) {
			throw new DiretorioInvalido(diretorio, "Diretório inválido.");
		}
		File[] files = diretorio.listFiles();
		if (files.length == 0) {
			throw new DiretorioInvalido(diretorio, "Diretório vazio.");
		}
		Album album = new Album();
		
		for (int i = 0; i < files.length; i++) {
			Matcher matcher = this.pattern.matcher(files[i].getName());
			if (matcher.matches() == true) {
				String name = matcher.group().replaceAll(".jpg", "");
				this.scanner = new Scanner(name);
				this.scanner.useDelimiter("[-_]");
				int id = Integer.valueOf(this.scanner.next().replaceAll("IMG", ""));
				LocalDate data = LocalDate.parse(this.scanner.next(), DateTimeFormatter.ofPattern("yyyyMMdd"));
				String local = null;
				if (this.scanner.hasNext() == true) {
					local = this.scanner.next();
				}
				album.adicionar(id, data, local);
			}
		}
		return album;
	}
}
