package lima.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppCorridaSapos {

	public static void main(String[] args) {
		
		Corrida corrida = new Corrida(500);
		Sapo sapo = null;
		int qtdSapos = 5;
		
		// ExecutorService e = Executors.newFixedThreadPool(qtdSapos);
		ScheduledExecutorService e = Executors.newScheduledThreadPool(qtdSapos);
		
		Sapo[] sapos = new Sapo[qtdSapos];
		for (int i = 0; i < sapos.length; i++) {
			sapos[i] = new Sapo("SAPO" + i, corrida);
		}
		System.out.println("INICIANDO CORRIDA.");
//		for (int i = 0; i < sapos.length; i++) {
//			e.execute(sapos[i]);
//		}
		for (int i = 0; i < sapos.length; i++) {
			e.schedule(sapos[i], 2000, TimeUnit.MILLISECONDS);
		}
		
		e.shutdown();
		
		while (e.isTerminated() == false) {
			try {
				Thread.sleep(500L);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		System.out.println("FIM DA CORRIDA.");
		corrida.exibirResultado();
	}
}
