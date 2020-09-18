/*
 * Neste exercício, você deve completar 4 tarefas:
 * 1. Imprima todos os números inteiros de 10 a 25 utilizando uma estrutura de repetição.
 * 2. Imprima a soma dos números de 1 a 100, pulando de dois em dois (1, 3, 5, 7, etc.).
 * 3. Começando em 0, imprima os números seguintes, enquanto a soma dos números já impressos for menor que 100.
 * 4. Imprima a tabuada do 9 (até o décimo valor).
 * */
public class EstruturaDeRepeticao {

	public static void main(String[] args) {
		
		// números inteiros de 10 a 25
		for (int i = 10; i <= 25; i++) {
			System.out.println(i);
		}
		
		// soma dos números de 1 a 100, pulando de dois em dois
		int soma = 0;
		for (int i = 1; i <= 100; i+=2) {
			soma += i;
		}
		System.out.println("Soma = " + soma);
		
		// Começando em 0, soma dos números menor que 100.
		int cont = 0;
		soma = 0;
		while (cont < 100) {
			soma += cont;
			cont++;
		}
		System.out.println("Soma = " + soma);
		
		// tabuada de 9
		System.out.println("Tabuada de 9:");
		int num = 9;
		for (int i = 1; i <= 10; i++) {
			System.out.println(num + " X " + i + " = " + (num * i));
		}
	}
}
