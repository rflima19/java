package com.lima.salvalivros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoLivro {

	public static void main(String[] args) {
		AplicacaoLivro app = new AplicacaoLivro();
		String separador = System.getProperty("file.separator");
		File arquivo = new File("." + separador + "files" + separador + "livros.bin");
		Scanner console = new Scanner(System.in);
		int opcao = 0;

		while (true) {
			try {
				System.out.println("1 - Ler dados");
				System.out.println("2 - Escrever dados");
				System.out.print(">>");
				opcao = Integer.valueOf(console.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Digite os números 1 ou 2.");
				continue;
			}
			if ((opcao != 1) && (opcao != 2)) {
				System.out.println("Opção incorreta.");
				continue;
			}
			break;
		}

		try {
			if (opcao == 1) {
				List<Livro> livros = app.ler(arquivo);
				System.out.println("LIVROS:");
				System.out.println("-------------------------------------------------------------------");
				System.out.printf("%-10s\t%-10s\t%-10s\t%-10s%n", "TÍTULO", "NUM_PÁGINAS", "NOME_AUTOR", "DATA_NASCIMENTO");
				System.out.println("-------------------------------------------------------------------");
				for (Livro l : livros) {
					System.out.printf("%-10s\t%-10d\t%-10s\t%-10s%n", 
							l.getTitulo(), l.getNumPaginas(), l.getAutor().getNome(), l.getAutor().getDataNascimento().toString());
					System.out.println("-------------------------------------------------------------------");
				}
			} else if (opcao == 2) {
				app.escrever(arquivo);
				System.out.println("Dados escritos");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Livro> ler(File arquivo) throws FileNotFoundException, IOException {
		List<Livro> livros = new ArrayList<>();
		Livro livro = null;
		try (InputStream inBytes = new FileInputStream(arquivo);
				DataInputStream inData = new DataInputStream(inBytes)) {
			while (inData.available() > 0) {
				livro = new Livro();
				livro.read(inData);
				livros.add(livro);
			}
		}
		return livros;
	}

	public void escrever(File arquivo) throws FileNotFoundException, IOException {
		if (arquivo.exists() == false) {
			arquivo.createNewFile();
		}
		Autor a1 = new Autor("Autor 1", LocalDate.of(1978, 3, 15));
		Livro l1 = new Livro("Livro 1", 300, a1);

		Autor a2 = new Autor("Autor 2", LocalDate.of(1996, 6, 23));
		Livro l2 = new Livro("Livro 2", 500, a2);

		try (OutputStream outBytes = new FileOutputStream(arquivo);
				DataOutputStream outData = new DataOutputStream(outBytes)) {
			l1.write(outData);
			l2.write(outData);
		}
	}
}
