package com.lima.regex.jogodaforca.repository;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.lima.regex.jogodaforca.model.Palavra;

public class RepositoryFile implements Repository {

	private File path;
	private File file;
	private final String EXTENSAO = ".txt";

	public RepositoryFile() {
		super();
		String separador = System.getProperty("file.separator");
		String fonte = "." + separador + "files";
		this.path = new File(fonte);
	}

	@Override
	public List<Palavra> carregarPalavras(String nomeArquivo) {
		String separador = System.getProperty("file.separator");
		this.file = new File(this.path.getPath() + separador + nomeArquivo + this.EXTENSAO);
		List<Palavra> palavras = new ArrayList<>();
		try (Scanner scanner = new Scanner(this.file)) {
			scanner.useDelimiter(Pattern.compile(";"));
			while (scanner.hasNext()) {
				Palavra palavra = new Palavra(scanner.next());
				palavras.add(palavra);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return palavras;
	}

	@Override
	public String[] carregarTemas() {
		String regex = "[a-zA-Z]+\\.txt$";
		File[] files = this.path.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isFile() == true) {
					if (Pattern.matches(regex, pathname.getName()) == true) {
						return true;
					}
				}
				return false;
			}
		});
		String[] temas = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			temas[i] = files[i].getName().replaceAll(this.EXTENSAO, "");
		}
		return temas;
	}

}
