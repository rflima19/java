/*
 * Escreva um programa que imprime na sa�da os valores assumidos por x. Esta vari�vel x deve
 * iniciar com algum valor escolhido por voc�. Se x for par, x deve receber o valor dele mesmo
 * somado com 5. J� se x for �mpar, x deve receber o valor dele multiplicado por 2. O programa
 * termina assim que x for maior que 1000.
 * Por exemplo, para x = 10, a sa�da deve ser: 15, 30, 35, 70, 75, 150, 155, 310, 315, 630, 635, 1270.
 * Crie este programa primeiro usando a estrutura de controle if-else e depois usando a
 * estrutura de controle switch.
 * */
public class ParOuImpar {

	public static void main(String[] args) {
		int x = 10;
		
		// usando if else
		do {
			if (x % 2 == 0) {
				x += 5;
			} else {
				x *= 2;
			}
			System.out.println(x);
		} while (x < 1000);
		
		// usando switch
		int aux = 0;
		do {
			aux = x % 2;
			switch (aux) {
			case 0 -> {
				x += 5;
				System.out.println(x);
			}
			default -> {
				x *= 2;
				System.out.println(x);
			}
			}
		} while (x < 1000);
	}
}
