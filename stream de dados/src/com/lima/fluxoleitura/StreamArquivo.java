package com.lima.fluxoleitura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class StreamArquivo {
	
	public static void main(String[] args) {
			
//		File arquivo = new File(".\\files\\entrada.txt");
//		
//		StreamArquivo.lerArquivoTextoFluxoBytes(arquivo);
//		StreamArquivo.lerArquivoTextoFluxoCaracter(arquivo);
//		StreamArquivo.lerArquivoTextoFluxoCaracterBuffer(arquivo);
//		StreamArquivo.lerArquivoTextoFluxoCaracterFileReader(arquivo);
//		StreamArquivo.lerArquivoTextoFluxoCaracterFileReaderBuffer(arquivo);
//		StreamArquivo.lerArquivoScanner(arquivo);
		
//		File arquivo = new File(".\\files\\saida.txt");
//		
//		String texto = String.format("%s", "Texto para ser escrito no arquivo." +
//									"%nlinha 2%n linha 3");
//		StreamArquivo.escreverArquivoTextoFluxoBytes(arquivo, texto);
//		StreamArquivo.escreverArquivoTextoFluxoCaracter(arquivo, texto);
//		StreamArquivo.escreverArquivoTextoFluxoCaracterBuffer(arquivo, texto);
//		StreamArquivo.escreverArquivoTextoFluxoCaracterFileWriter(arquivo, texto);
//		StreamArquivo.escreverArquivoTextoFluxoCaracterFileWriterBuffer(arquivo, texto);
//		StreamArquivo.escreverArquivoTextoPrintWriter(arquivo, texto);
//		StreamArquivo.escreverArquivoTextoPrintStream(arquivo, texto);
		
		String separador = System.getProperty("file.separator");
		File arquivoFonte = new File("." + separador + "files" + separador + "saida.txt");
		File arquivoDestino = new File("." + separador + "files" + separador + "copia.txt");
		StreamArquivo.copiarArquivo(arquivoFonte, arquivoDestino);
	}

	public static void lerArquivoTextoFluxoBytes(File arquivo) {
		InputStream in = null;
		try {
			in = new FileInputStream(arquivo);
			
//			int byteLido = 0;
//			while ((byteLido = in.read()) != -1) {
//				System.out.printf("%d = %s%n", byteLido, Character.toString((byte)byteLido));
//			}
			
			byte[] buffer = new byte[1024];
			int qtdBytesLidos = -1;
			while ((qtdBytesLidos = in.read(buffer)) > -1) {
				String s = new String(buffer, 0, qtdBytesLidos);
				System.out.printf(s);
			}
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.err.printf("Erro ao fechar o arquivo %s.%n", arquivo.getAbsolutePath());
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void lerArquivoTextoFluxoCaracter(File arquivo) {
		try (InputStream inStreamBytes = new FileInputStream(arquivo);
				Reader inStreamChar = new InputStreamReader(inStreamBytes)) {
			char[] caracteres = new char[1024];
			int qtdCaracteresLidos= -1;
			while ((qtdCaracteresLidos = inStreamChar.read(caracteres)) > -1) {
				String s = new String(caracteres, 0, qtdCaracteresLidos);
				System.out.printf(s);
			}
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void lerArquivoTextoFluxoCaracterBuffer(File arquivo) {
		try (InputStream inStreamBytes = new FileInputStream(arquivo);
				Reader inStreamChar = new InputStreamReader(inStreamBytes);
				BufferedReader inStreamBuffer = new BufferedReader(inStreamChar)) {
			String line = null;
			while ((line = inStreamBuffer.readLine()) != null) {
				System.out.printf(line);
			}
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void lerArquivoTextoFluxoCaracterFileReader(File arquivo) {
		try (FileReader in = new FileReader(arquivo)) {
			char[] caracteres = new char[1024];
			int qtdCaracteresLidos= -1;
			while ((qtdCaracteresLidos = in.read(caracteres)) > -1) {
				String s = new String(caracteres, 0, qtdCaracteresLidos);
				System.out.printf(s);
			}
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void lerArquivoTextoFluxoCaracterFileReaderBuffer(File arquivo) {
		try (FileReader in = new FileReader(arquivo);
				BufferedReader buffer = new BufferedReader(in)) {
			String line = null;
			while ((line = buffer.readLine()) != null) {
				System.out.printf(line);
			}
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void lerArquivoScanner(File arquivo) {
		try (InputStream in = new FileInputStream(arquivo); 
				Scanner scanner = new Scanner(in)) {
			scanner.useDelimiter("\n");
			String line = null;
			StringBuilder strb = new StringBuilder();
			while (scanner.hasNextLine()) {
				line = scanner.next();
				strb.append(line);
			}
			System.out.printf(strb.toString());
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("Erro na leitura do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void escreverArquivoTextoFluxoBytes(File arquivo, String texto) {
//		if (arquivo.exists() == false) {
//			try {
//				arquivo.createNewFile();
//			} catch (IOException e) {
//				System.err.printf("Erro ao criar o arquivo %s.%n", arquivo.getAbsolutePath());
//				e.printStackTrace();
//				return;
//			}
//		}
		try (OutputStream out = new FileOutputStream(arquivo)) {
			byte[] arrayBytes = texto.getBytes();
			out.write(arrayBytes);
			
//			Scanner s = new Scanner(texto);
//			s.useDelimiter("\n");
//			byte[] arrayBytes = null;
//			while (s.hasNextLine()) {
//				arrayBytes = s.next().getBytes();
//				out.write(arrayBytes);
//			}
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("Erro na escrita do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void escreverArquivoTextoFluxoCaracter(File arquivo, String texto) {
		try (OutputStream outStreamBytes = new FileOutputStream(arquivo);
				Writer outStreamCaracter = new OutputStreamWriter(outStreamBytes)) {
			outStreamCaracter.write(texto);
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("Erro na escrita do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void escreverArquivoTextoFluxoCaracterBuffer(File arquivo, String texto) {
		try (OutputStream outStreamBytes = new FileOutputStream(arquivo);
				Writer outStreamCaracter = new OutputStreamWriter(outStreamBytes);
				BufferedWriter outputStreamBuffer = new BufferedWriter(outStreamCaracter)) {
			outputStreamBuffer.write(texto);
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("Erro na escrita do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void escreverArquivoTextoFluxoCaracterFileWriter(File arquivo, String texto) {
		try (FileWriter out = new FileWriter(arquivo)) {
			out.write(texto);
		} catch (IOException e) {
			System.err.printf("Erro na escrita do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void escreverArquivoTextoFluxoCaracterFileWriterBuffer(File arquivo, String texto) {
		try (FileWriter out = new FileWriter(arquivo);
				BufferedWriter buffer = new BufferedWriter(out)) {
			buffer.write(texto);
		} catch (IOException e) {
			System.err.printf("Erro na escrita do arquivo %s.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void escreverArquivoTextoPrintWriter(File arquivo, String texto) {
//		try (OutputStream outStreamBytes = new FileOutputStream(arquivo);
//				PrintWriter outPrintWriter = new PrintWriter(outStreamBytes)) {
//			outPrintWriter.printf("%s %d%n", "Arquivo escrito com PrintWriter", 10);
//			outPrintWriter.write(texto);
//		} catch (FileNotFoundException e) {
//			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.err.printf("Erro na escrita do arquivo %s.%n", arquivo.getAbsolutePath());
//			e.printStackTrace();
//		}
		
		try (PrintWriter out = new PrintWriter(arquivo)) {
			out.printf("%s %d%n", "Arquivo escrito com PrintWriter", 10);
			out.write(texto);
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void escreverArquivoTextoPrintStream(File arquivo, String texto) {
//		try (OutputStream outStreamBytes = new FileOutputStream(arquivo);
//				PrintStream outPrintStream = new PrintStream(outStreamBytes)) {
//			outPrintStream.printf("%s %d%n", "Arquivo escrito com PrintStream", 10);
//			outPrintStream.println(texto);
//		} catch (FileNotFoundException e) {
//			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.err.printf("Erro na escrita do arquivo %s.%n", arquivo.getAbsolutePath());
//			e.printStackTrace();
//		}
		
		try (PrintStream out = new PrintStream(arquivo)) {
			out.printf("%s %d%n", "Arquivo escrito com PrintStream", 10);
			out.println(texto);
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo %s não encontrado.%n", arquivo.getAbsolutePath());
			e.printStackTrace();
		}
	}
	
	public static void copiarArquivo(File arquivoFonte, File arquivoSaida) {
		try (InputStream in = new FileInputStream(arquivoFonte);
				OutputStream out = new FileOutputStream(arquivoSaida)) {
			int qtdBytesLidos = -1;
			byte[] buffer = new byte[1024];
			while ((qtdBytesLidos = in.read(buffer)) > -1) {
				out.write(buffer, 0, qtdBytesLidos);
			}
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo não encontrado.%n");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("Erro na cópia do arquivo %s.%n", arquivoFonte.getAbsolutePath());
			e.printStackTrace();
		}
	}
}
