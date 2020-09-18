
public class SwitchExpression {

	public enum DiaDaSemana {
		SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO;
	}

	public static void main(String[] args) {

		DiaDaSemana d = DiaDaSemana.SEGUNDA;

		// Estrutura switch tradicional
//		switch (d) {
//		case SEGUNDA:
//			System.out.println("Dia 1 da semana.");
//			//break;
//		case TERCA:
//			System.out.println("Dia 2 da semana.");
//			//break;
//		case QUARTA:
//			System.out.println("Dia 3 da semana.");
//			//break;
//		case QUINTA:
//			System.out.println("Dia 4 da semana.");
//			//break;
//		case SEXTA:
//			System.out.println("Dia 5 da semana.");
//			//break;
//		case SABADO:
//			System.out.println("Dia 6 da semana.");
//			//break;
//		case DOMINGO:
//			System.out.println("Dia 7 da semana.");
//			//break;
//		default:
//			System.out.println("Outro");	
//		
//		}

		// Estrutura switch expression
		switch (d) {
		case SEGUNDA -> System.out.println("Dia 1 da semana."); // não precisa utilizar break
		case TERCA -> {
			// pode utilizar um bloco para declarar mais de uma instrução.
			System.out.println("Dia 2 da semana.");
		}
		case QUARTA -> {
			System.out.println("Dia 3 da semana.");
		}
		case QUINTA -> System.out.println("Dia 4 da semana.");
		case SEXTA -> System.out.println("Dia 5 da semana.");
		case SABADO -> System.out.println("Dia 6 da semana.");
		case DOMINGO -> System.out.println("Dia 7 da semana.");
		default -> System.out.println("Outro");
		}

		// Podemos atribuir o resultado do switch expression para uma variável.
		// Neste caso a switch expression deve verificar obrigatoriamente todas
		// as possibilidades para o enum ou utlizar o default.
		SwitchExpression sw = new SwitchExpression();
		int i = switch (d) {
		// case SEGUNDA -> 1;
		case TERCA -> 2;
		case QUARTA -> {
			yield 3; // para retorna um valor para a variável quando usado um bloco temos que usar o
						// identificador restrito yield
		}
		case QUINTA -> {
			yield 4;
		}
		case SEXTA -> {
			yield sw.func();
		}
		case SABADO -> 6;
		case DOMINGO -> 7;
		default -> 0;
		};

		System.out.println(i);

		// Podemos definir mais de uma opção por case, além de lançar exception para cima.
		String dia = "recebe o valor aqui";
		switch (dia) {
		case "Domingo" -> System.out.println("É dia de descanço!!!");
		case "Segunda", "Terça" -> { // mais de uma opção por case
			// aqui entra seu código
		}
		default -> throw new RuntimeException("Não é um dia da semana válido");
		}
		
	}

	public int func() {
		return 5;
	}
}
