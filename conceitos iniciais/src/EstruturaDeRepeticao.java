/*
 * Neste exerc�cio, voc� deve completar 4 tarefas:
 * 1. Imprima todos os n�meros inteiros de 10 a 25 utilizando uma estrutura de repeti��o.
 * 2. Imprima a soma dos n�meros de 1 a 100, pulando de dois em dois (1, 3, 5, 7, etc.).
 * 3. Come�ando em 0, imprima os n�meros seguintes, enquanto a soma dos n�meros j� impressos for menor que 100.
 * 4. Imprima a tabuada do 9 (at� o d�cimo valor).
 * */
public class EstruturaDeRepeticao {

	public static void main(String[] args) {
		
		// n�meros inteiros de 10 a 25
		for (int i = 10; i <= 25; i++) {
			System.out.println(i);
		}
		
		// soma dos n�meros de 1 a 100, pulando de dois em dois
		int soma = 0;
		for (int i = 1; i <= 100; i+=2) {
			soma += i;
		}
		System.out.println("Soma = " + soma);
		
		// Come�ando em 0, soma dos n�meros menor que 100.
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
