/*
 * Um aluno tirou notas 8.5, 7.5 e 6.0 em provas que tinham peso 3, 2 e 5, respectivamente.
 * Escreva um programa que imprima a média do aluno. 
 */
public class MediaPonderada {

	public static void main(String[] args) {

		int pesoProva1 = 3;
		int pesoProva2 = 2;
		int pesoProva3 = 5;

		double notaProva1 = 8.5;
		double notaProva2 = 7.5;
		double notaProva3 = 6.0;

		double media = 0.0;

		media = (pesoProva1 * notaProva1 + pesoProva2 * notaProva2 + pesoProva3 * notaProva3)
				/ (pesoProva1 + pesoProva2 + pesoProva3);

		System.out.println("Média = " + media);
	}
}
