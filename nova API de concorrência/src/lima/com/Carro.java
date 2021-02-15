package lima.com;

public class Carro implements Runnable {

	private int id;
	private Semaforo semaforo;
	
	public Carro(int id, Semaforo semaforo) {
		super();
		this.id = id;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		while (true) {
			this.semaforo.atravessar(this.id);
			try {
				Thread.sleep(1000 + (int) (Math.random() * 4000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
