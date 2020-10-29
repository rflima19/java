package com.lima.listacompras;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.lima.listacompras.exceptions.ArquivoVazioException;
import com.lima.listacompras.exceptions.CompraInvalidaException;
import com.lima.listacompras.exceptions.NomeInvalidoException;
import com.lima.listacompras.exceptions.PesoInvalidoException;
import com.lima.listacompras.exceptions.PrecoInvalidoException;
import com.lima.listacompras.exceptions.QuantidadeInvalidaException;

public class AplicacaoListaCompras {

	public static void main(String[] args) {

		AplicacaoListaCompras app = new AplicacaoListaCompras();
		int opcao = 0;
		Set<Compra> compras = null;
		Set<Item> itens = null;
		Compra compra = null;
		DateTimeFormatter formatData = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		NumberFormat formatMoeda = NumberFormat.getCurrencyInstance(Locale.getDefault());
		DecimalFormat formatPeso = new DecimalFormat("#,###.00 KG");

		try (InputStream inStreamBytes = System.in;
				InputStreamReader inStreamCaracter = new InputStreamReader(inStreamBytes);
				BufferedReader buffer = new BufferedReader(inStreamCaracter)) {
			while (true) {
				System.out.println("1 - Realizar Compra");
				System.out.println("2 - Listar Compras");
				System.out.println("0 - Sair");
				System.out.print(">>");
				opcao = Integer.valueOf(buffer.readLine());

				if (opcao == 0) {
					break;
				}
				
				switch (opcao) {
				case 1 -> {
					try {
						itens = app.realizarCompra(buffer);
						compra = app.finalizarCompra(itens);
						app.salvarCompra(compra);
					} catch (CompraInvalidaException e) {
						System.err.println(e.getMessage());
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						System.err.println("Arquivo não encontrado.");
						e.printStackTrace();
					} catch (SecurityException e) {
						System.err.println("Sem permissão de leitura / escrita.");
						e.printStackTrace();
					} catch (IOException e) {
						System.err.println("Erro de I/O.");
						e.printStackTrace();
					}
				}
				case 2 -> {
					try {
						compras = app.lerListaCompras();
						System.out.printf("%n--------------------------------------------------------------------------------------------------------------%n");
						System.out.printf("################################################ COMPRAS #####################################################");
						System.out.printf("%n--------------------------------------------------------------------------------------------------------------%n");
						int i = 1;
						int j = 1;
						for (Compra c : compras) {
							System.out.printf("%-20s %-20s %-20s", "NÚMERO_COMPRA", "DATA_COMPRA", "VALOR_COMPRA");
							System.out.printf("%n--------------------------------------------------------------------------------------------------------------%n");
							System.out.printf("%-20d %-20s %-20s%n", i, formatData.format(c.getData()), formatMoeda.format(c.getValor()));
							itens = c.getItens();
							System.out.printf("\t%-20s %-20s  %-20s  %-20s  %-20s%n", "NÚMERO_ITEM", "NOME_ITEM", 
									"PREÇO_ITEM", "PESO_ITEM", "QUANTIDADE_ITEM");
							System.out.printf("\t------------------------------------------------------------------------------------------------------%n");
							for (Item item : itens) {
								System.out.printf("\t%-20d %-20s  %-20s  %-20s  %-10d%n", 
										j, item.getNome(), formatMoeda.format(item.getPreco()), 
										formatPeso.format(item.getPeso()), item.getQuantidade());
								j++;
								System.out.printf("\t------------------------------------------------------------------------------------------------------%n");
							}
							i++;
							j = 1;
							System.out.printf("--------------------------------------------------------------------------------------------------------------%n");
						}
						System.out.printf("%n");
					}catch (ArquivoVazioException e) {
						System.err.println(e.getArquivo().getAbsolutePath() + ": " + e.getMessage());
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						System.err.println("Arquivo não encontrado.");
						e.printStackTrace();
					} catch (IOException e) {
						System.err.println("Erro de I/O.");
						e.printStackTrace();
					} 
				}
				default -> {
					System.out.println(">> " + opcao + " não é uma opção válida.");
				}
				}
				
			}
		} catch (NumberFormatException e) {
			System.err.println("Entrada inválida.");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Erro de I/O.");
			e.printStackTrace();
		}
	}

	public Set<Item> realizarCompra(BufferedReader buffer) throws IOException {
		String entrada = null;
		Set<Item> itens = new HashSet<>();
		Item item = null;
		
		while (true) {
			item = new Item();
			try {
				System.out.println("Digite o nome do item (digite 0 para sair): ");
				System.out.print(">>");
				entrada = buffer.readLine();
				item.setNome(entrada);

				System.out.println("Digite o preço do item: ");
				System.out.print(">>");
				entrada = buffer.readLine();
				item.setPreco(Double.valueOf(entrada));

				System.out.println("Digite o peso do item: ");
				System.out.print(">>");
				entrada = buffer.readLine();
				item.setPeso(Double.valueOf(entrada));

				System.out.println("Digite a quantidade do item: ");
				System.out.print(">>");
				entrada = buffer.readLine();
				item.setQuantidade(Integer.valueOf(entrada));

				itens.add(item);
				
				System.out.println("Digite 1 para continuar a adicionar itens a compra: ");
				System.out.print(">>");
				entrada = buffer.readLine();
				if (entrada.equals("1") == false) {
					break;
				}
				
			} catch (NomeInvalidoException e) {
				System.out.println("Entrada: " + e.getNomeInvalido() + " é inválida. " + e.getMessage());
				System.out.println("Tente novamente!");
				continue;
			} catch (PesoInvalidoException e) {
				System.out.println("Entrada: " + e.getPesoInvalido() + " é inválida. " + e.getMessage());
				System.out.println("Tente novamente!");
				continue;
			} catch (PrecoInvalidoException e) {
				System.out.println("Entrada: " + e.getPrecoInvalido() + " é inválida. " + e.getMessage());
				System.out.println("Tente novamente!");
				continue;
			} catch (QuantidadeInvalidaException e) {
				System.out.println("Entrada: " + e.getQuantidadeInvalida() + " é inválida. " + e.getMessage());
				System.out.println("Tente novamente!");
				continue;
			} catch (NumberFormatException e) {
				System.out.println("Entrada: " + entrada + " é inválida. Digite um número real válido.");
				System.out.println("Tente novamente!");
				continue;
			}
		}
		return itens;
	}

	public Compra finalizarCompra(Set<Item> itensCompra) {
		Compra c = new Compra(itensCompra, LocalDateTime.now());
		return c;
	}
	
	public File getArquivo() {
		String home = System.getProperty("user.home");
		String separador = System.getProperty("file.separator");
		File diretorio = new File(home + separador + "appcompras");
		if (diretorio.exists() == false) {
			diretorio.mkdir();
		}
		File arquivo = new File(diretorio + separador + "compras.bin");
		return arquivo;
	}

	public void salvarCompra(Compra compra) throws FileNotFoundException, IOException, CompraInvalidaException {
		int quantidadeItensCompra = compra.getItens().size();
		if (quantidadeItensCompra == 0) {
			throw new CompraInvalidaException("Compra inválida -> sem itens definidos.");
		} else if (compra.getData() == null) {
			throw new CompraInvalidaException("Compra inválida -> sem data definida.");
		}

		File arquivo = this.getArquivo();

		try (RandomAccessFile randomAccessCompra = new RandomAccessFile(arquivo, "rw")) {
			long tamanhoArquivo = randomAccessCompra.length();
			randomAccessCompra.seek(tamanhoArquivo); // posiciona o ponteiro para o fim do arquivo
			compra.gravar(randomAccessCompra);
		}
	}
	
	public Set<Compra> lerListaCompras() throws FileNotFoundException, IOException, ArquivoVazioException {

		File arquivo = this.getArquivo();
		
		long tamanhoArquivo = arquivo.length();
		if (tamanhoArquivo == 0) {
			throw new ArquivoVazioException("Arquivo vazio.", arquivo);
		}
		
		Set<Compra> compras = new TreeSet<>(new OrdenacaoDataCompra());
		Compra compra = null;
		try (InputStream inBytes = new FileInputStream(arquivo);
				DataInputStream inData = new DataInputStream(inBytes)) {
			while (inData.available() > 0) {
				compra = new Compra();
				compra.ler(inData);
				compras.add(compra);
			}
		}
		
		return compras;
	}
}
