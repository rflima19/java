package com.lima.salvaItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AplicacaoLista {

	public static void main(String[] args) {
		try {
			String separador = System.getProperty("file.separator");
			File arquivo = new File("." + separador + "files" + separador + "lista.txt");
			arquivo.createNewFile();
			List<String> lista = null;

			lista = AplicacaoLista.lerItens(arquivo);
			if ((lista != null) && (lista.size() > 0)) {
				System.out.println("ITENS: ");
				Iterator<String> i = lista.iterator();
				while (i.hasNext()) {
					System.out.println(i.next());
					i.remove();
				}
			} else {
				System.out.println("Lista de itens está vazia.");
			}
			
			String nome = null;
			try (Scanner scanner = new Scanner(System.in)) {
				while (true) {
					System.out.println("Digite o nome do item (digite 0 para sair): ");
					System.out.print(">>");
					nome = scanner.nextLine();
					if (nome.equals("0")) {
						break;
					} else if (nome.isBlank()) {
						System.out.println("Digite o nome do item. Tente novamente!");
						continue;
					}
					lista.add(nome);
				}
			}
			
			AplicacaoLista.salvarItens(arquivo, lista);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> lerItens(File arquivo) throws FileNotFoundException, IOException {
		List<String> lista = new ArrayList<>();
		String s = null;
		try (FileReader reader = new FileReader(arquivo);
				BufferedReader buffer = new BufferedReader(reader)) {
			while ((s = buffer.readLine()) != null) {
				lista.add(s);
			}
		}
		return lista;
	}

	public static void salvarItens(File arquivo, List<String> lista) throws IOException {
		if (lista.isEmpty() == true) {
			return;
		}
		try (FileWriter writter = new FileWriter(arquivo, true); 
				PrintWriter print = new PrintWriter(writter)) {
			for (String item : lista) {
				print.printf("%s%n", item);
			}
		}
	}
}
