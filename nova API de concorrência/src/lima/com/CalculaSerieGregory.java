package lima.com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CalculaSerieGregory {

	public static final int NUM_THREADS = 10;
	
	public static final int NUM_ITERACOES = 1000000000;
	
	private List<FutureTask<Double>> futureTasks;
	
	public CalculaSerieGregory() {
		this.futureTasks = new ArrayList<>();
	}

	public double calcular() throws InterruptedException, ExecutionException {
		ExecutorService e = Executors.newFixedThreadPool(CalculaSerieGregory.NUM_THREADS);
		TarefaSerieGregory tsg = null;
		FutureTask<Double> ft = null;
		
		for (int i = 0; i < CalculaSerieGregory.NUM_THREADS; i++) {
			tsg = new TarefaSerieGregory(i);
			ft = new FutureTask<>(tsg);
			this.futureTasks.add(ft);
			e.execute(ft);
		}
		
		double soma = 0.0;
//		for (int i = 0; i < CalculaSerieGregory.NUM_THREADS; i++) {
//			soma += this.futureTasks.get(i).get();
//		}
		
		for (FutureTask<Double> futureTask : futureTasks) {
			soma += futureTask.get();
		}
		
		e.shutdown();
		
		return soma * 4;
	}
	
}
