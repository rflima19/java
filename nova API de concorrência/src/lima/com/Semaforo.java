package lima.com;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Semaforo implements Runnable {

	private boolean aberto;
	
	private ReentrantLock lock;
	private Condition condition;

	public Semaforo() {
		super();
		this.aberto = false;
		this.lock = new ReentrantLock(true);
		this.condition = this.lock.newCondition();
	}
	
	@Override
	public void run() {
		while (true) {
			this.lock.lock();
			try {
				this.aberto = !this.aberto;
				System.out.println("Semáforo aberto: " + this.aberto);
				if (this.aberto == true) {
					this.condition.signalAll();
				}
			} finally {
				this.lock.unlock();
			}
			try {
				Thread.sleep(1000 + (int) (Math.random() * 4000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void atravessar(int id) {
		this.lock.lock();
		try {
			while (this.aberto == false) {
				System.out.println("[Carro " + id + "] aguadando");
				this.condition.await();
			}
			System.out.println("[Carro " + id + "] atravessou");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.lock.unlock();
		}
	}
}
