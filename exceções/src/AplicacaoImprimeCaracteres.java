import java.io.IOException;

/*
 *  Escreva um programa em JAVA que recebe dois strings, S1 e S2 e um número N
 *  pela linha de comando e imprima:
 *  	Os N primeiros caracteres do String S1 separados por um “-”;
 *  	Os N primeiros caracteres do String S1 de traz para diante;
 *  	Os N primeiros caracteres do String S2 separados por um “-”;
 *  	Os N primeiros caracteres do String S2 de traz para diante.
 * 
 * */

public class AplicacaoImprimeCaracteres {

	public static void main(String[] args) {
		String str1 = null;
		String str2 = null;
		String resultado = null;
		char[] caracteres = null;
		char separador = '-';
		int quatidade = 0;

		try {
			System.out.println("Digite uma palavra: ");
			str1 = Console.readString();

			System.out.println("Digite outra palavra: ");
			str2 = Console.readString();

			System.out.println("Digite a quantidade de caracteres desejados: ");
			quatidade = Console.readInt();
			
			caracteres = AplicacaoImprimeCaracteres.pegarCaracteres(str1, quatidade, false);
			resultado = AplicacaoImprimeCaracteres.gerarString(caracteres, separador);
			System.out.println("Os " + quatidade + " primeiros caracteres do String " + str1 + ": " + resultado);
			
			caracteres = AplicacaoImprimeCaracteres.pegarCaracteres(str1, quatidade, true);
			resultado = AplicacaoImprimeCaracteres.gerarString(caracteres, null);
			System.out.println("Os " + quatidade + " primeiros caracteres do String " + str1 + " de traz para frente: " + resultado);
			
			caracteres = AplicacaoImprimeCaracteres.pegarCaracteres(str2, quatidade, false);
			resultado = AplicacaoImprimeCaracteres.gerarString(caracteres, separador);
			System.out.println("Os " + quatidade + " primeiros caracteres do String " + str2 + ": " + resultado);
			
			caracteres = AplicacaoImprimeCaracteres.pegarCaracteres(str2, quatidade, true);
			resultado = AplicacaoImprimeCaracteres.gerarString(caracteres, null);
			System.out.println("Os " + quatidade + " primeiros caracteres do String " + str2 + " de traz para frente: " + resultado);
		
		} catch (IOException e) {
			System.err.println("Erro ao ler o dado do teclado");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.err.println("Argumento inválido: " + e.getMessage());
			e.printStackTrace();	
		} catch (RuntimeException e) {
			System.err.println("Valor digitado é invalido: " + e.getMessage());
			e.printStackTrace();
		} catch (QuantidadeCaracteresInsuficienteException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
			
		
	}

	private static char[] pegarCaracteres(String palavra, int quantidade, boolean inverterPalavra)
			throws QuantidadeCaracteresInsuficienteException {
		if (quantidade <= 0) {
			throw new IllegalArgumentException("O valor de " + quantidade + " é inválido como argumento.");
		}
		if (quantidade > palavra.length()) {
			throw new QuantidadeCaracteresInsuficienteException("A quantidade de " + quantidade
					+ " caracteres solicitados é superior a quantidade de caracteres da palavra " + palavra);
		}
		if (inverterPalavra == true) {
			palavra = new StringBuilder(palavra).reverse().toString();
		}
		char[] caracteres = new char[quantidade];
		for(int i = 0; i < quantidade; i++) {
			caracteres[i] = palavra.charAt(i);
		}
		
		return caracteres;
	}
	
	private static String gerarString(char[] caracteres, Character separador) {
		if (caracteres == null) {
			throw new IllegalArgumentException("Argumento inválido: array nulo");
		}
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < caracteres.length; i++) {
			s.append(caracteres[i]);
			if (separador != null && i != caracteres.length - 1) {
				s.append(separador);
			}
		}
		return s.toString();
	}
}
