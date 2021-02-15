package lima.com;

import java.util.Random;

public class Produtor implements Runnable {

	private Buffer<Integer> lista;
	private Random random;
	
	public Produtor(Buffer<Integer> lista) {
		this.lista = lista;
		this.random = new Random();
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(this.random.nextInt(10) * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.lista.escrever(Integer.valueOf(this.random.nextInt(100)));	
		}
	}
}
