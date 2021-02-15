package lima.com;

public class Incrementador implements Runnable {

	private Contador cont;

	public Incrementador(Contador cont) {
		super();
		this.cont = cont;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int valor = this.cont.incrementarMaisUm();
			System.out.println(Thread.currentThread().getName() + ": gerou valor " + valor + " em " + System.currentTimeMillis());
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
