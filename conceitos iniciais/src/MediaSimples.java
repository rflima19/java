/* Crie uma aplica��o que possibilita a entrada via console de um conjunto de notas de um aluno.
 * Assim que -1 for informado como nota, calcule a m�dia das notas informadas anteriormente e
 * mostre na tela. Caso a nota do aluno seja inv�lida, mostre uma mensagem na tela solicitando
 * uma nova nota.
*/
public class MediaSimples {

	public static void main(String[] args) {
		double nota = 0.0;
		double soma = 0.0;
		double media = 0.0;
		int qtdNotas = 0;

		do {
			System.out.println("Digite a " + (qtdNotas + 1) + "� nota do aluno:");
			nota = Console.readDouble();
			if (nota < -1.0 || nota > 10.0) {
				System.out.println("Nota " + nota + " inv�lida. Digite novamente!");
				continue;
			}
			if (nota != -1) {
				qtdNotas++;
				soma += nota;
			}
		} while (nota != -1);

		media = soma / qtdNotas;
		
		System.out.println("M�dia do aluno: " + media);
	}
}
