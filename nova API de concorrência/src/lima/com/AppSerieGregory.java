package lima.com;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;

public class AppSerieGregory {

	public static void main(String[] args) {
		
		Instant inicio = Instant.now();
		
//		AppSerieGregory sg = new AppSerieGregory();
//		
//		int n = 1000000000;
//		// int n = 397127800;
//		
//		double soma1 = sg.calcularFormaSequecial(n);
//		System.out.println("Valor de PI: " + soma1);
		
		try {
			CalculaSerieGregory csg = new CalculaSerieGregory();
			double soma2 = csg.calcular();
			System.out.println("Valor de PI: " + soma2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		Instant fim = Instant.now();
		
		Duration tempoExecucao = Duration.between(inicio, fim);
		System.out.println("Tempo de execução: " + tempoExecucao.getSeconds());
	}
	
	public double calcularFormaSequecial(int n) {
		double soma = 0.0;
		int aux = 0;
		for (int i = 0; i <= n; i++) {
			// soma += (Math.pow(-1, i)) / (2 * i + 1);
			if (i % 2 == 0) {
				aux = 1;
			} else {
				aux = -1;
			}
			soma += (double) aux / (2 * i + 1);
		}
		return soma * 4;
	}
}
