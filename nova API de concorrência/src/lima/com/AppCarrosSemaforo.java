package lima.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppCarrosSemaforo {

	public static final int NUM_CARROS = 5;
	
	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(AppCarrosSemaforo.NUM_CARROS + 1);
		
		Semaforo semaforo = new Semaforo();
		e.execute(semaforo);
		
		for (int i = 0; i < AppCarrosSemaforo.NUM_CARROS; i++) {
			Carro carro = new Carro(i, semaforo);
			e.execute(carro);
		}
		
		e.shutdown();
	}
}
