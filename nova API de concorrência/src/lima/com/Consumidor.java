package lima.com;

import java.util.Random;

public class Consumidor implements Runnable {

	private Buffer<Integer> lista;
	
	public Consumidor(Buffer<Integer> lista) {
		this.lista = lista;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		while (true) {
			try {
				Thread.sleep(random.nextInt(10) * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.lista.ler();	
		}
	}
}
