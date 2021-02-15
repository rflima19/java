package lima.com;

import java.util.concurrent.Callable;

public class TarefaSerieGregory implements Callable<Double> {

	private int id;
	
	public TarefaSerieGregory(int id) {
		super();
		this.id = id;
	}

	@Override
	public Double call() throws Exception {
		double soma = 0.0;
		int aux = 0;
		for (int i = this.id; i <= CalculaSerieGregory.NUM_ITERACOES; i += CalculaSerieGregory.NUM_THREADS) {
			if (i % 2 == 0) {
				aux = 1;
			} else {
				aux = -1;
			}
			soma += (double) aux / (2 * i + 1);
		}
		return soma;
	}
}
