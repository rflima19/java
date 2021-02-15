package lima.com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ListaProdutorConsumidor1<T> implements Buffer<T> {

	private List<T> lista;
	private int tamanho;
	private Lock lock;
	private Condition condition;
	
	public ListaProdutorConsumidor1(int tamanho) {
		if (tamanho <= 0) {
			throw new IllegalArgumentException("Tamanho deve ser maior que zero(0).");
		}
		this.lista = new ArrayList<>();
		this.tamanho = tamanho;
		this.lock = new ReentrantLock(true);
		this.condition = this.lock.newCondition();
	}
	
	public void escrever(T obj) {
		this.lock.lock();
		try {
			while (this.lista.size() >= tamanho) {
				try {
					this.condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.lista.add(obj);
			this.imprimir();
			this.condition.signalAll();
		} finally {
			this.lock.unlock();
		}
	}
	
	public T ler() {
		this.lock.lock();
		T obj = null;
		try {
			while (this.lista.size() <= 0) {
				try {
					this.condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			obj = this.lista.remove(0);
			this.imprimir();
			this.condition.signalAll();
		} finally {
			this.lock.unlock();
		}
		return obj;
	}
	
	public void imprimir() {
		this.lista.stream().forEach(obj -> System.out.printf("%02d ", obj));
		System.out.printf("%n");
	}
}
