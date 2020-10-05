
public class AplicacaoOperacao {

	public static void main(String[] args) {
		Operacao soma = Operacao.SOMA;
		Operacao subtracao = Operacao.SUBTRACAO;
		Operacao multiplicacao = Operacao.MULTIPLICACAO;
		Operacao divisao = Operacao.DIVISAO;
		
		double n1 = 50.5;
		int n2 = 3;
		
//		System.out.printf("%.2f %c %d = %.2f%n", n1, soma.getSimbolo(), n2, soma.calcular(n1, n2));
//		System.out.printf("%.2f %c %d = %.2f%n", n1, subtracao.getSimbolo(), n2, subtracao.calcular(n1, n2));
//		System.out.printf("%.2f %c %d = %.2f%n", n1, multiplicacao.getSimbolo(), n2, multiplicacao.calcular(n1, n2));
//		System.out.printf("%.2f %c %d = %.2f%n", n1, divisao.getSimbolo(), n2, divisao.calcular(n1, n2));
		
		System.out.printf("%.2f %s %d = %.2f%n", n1, soma, n2, soma.calcular(n1, n2));
		System.out.printf("%.2f %s %d = %.2f%n", n1, subtracao, n2, subtracao.calcular(n1, n2));
		System.out.printf("%.2f %s %d = %.2f%n", n1, multiplicacao, n2, multiplicacao.calcular(n1, n2));
		System.out.printf("%.2f %s %d = %.2f%n", n1, divisao, n2, divisao.calcular(n1, n2));
	}
}
