package lima.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppProdutorConsumidor {

	public static void main(String[] args) {
		// Buffer<Integer> lista = new ListaProdutorConsumidor<>(10);
		// Buffer<Integer> lista = new ListaProdutorConsumidor2<>(10);
		// Buffer<Integer> lista = new ListaProdutorConsumidor3<>(10);
		Buffer<Integer> lista = new ListaProdutorConsumidor4<>(10);
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			exec.execute(new Produtor(lista));
		}
		for (int i = 0; i < 10; i++) {
			exec.execute(new Consumidor(lista));
		}
		exec.shutdown();
	}
}
