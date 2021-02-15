package lima.com;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class AppSomador {

	public static void main(String[] args) {
		
		Somador somador = new Somador(30, 100);
		ExecutorService e = Executors.newSingleThreadExecutor();
		FutureTask<Integer> ft = new FutureTask<>(somador);
		e.execute(ft);
		
		while (ft.isDone() == false) {
			System.out.println("Aguandando...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		try {
			int resultado = ft.get();
			System.out.println("Resultado: " + resultado);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		
		e.shutdown();
	}
}
