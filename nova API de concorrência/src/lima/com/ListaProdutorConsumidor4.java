package lima.com;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ListaProdutorConsumidor4<T> implements Buffer<T> {

	private LinkedList<T> lista;
	private int tamanho;
	private ReentrantReadWriteLock lock;
	private final ReentrantReadWriteLock.ReadLock readLock;   
	private final ReentrantReadWriteLock.WriteLock writeLock;
//	private Condition conditionRead;
	private Condition conditionWrite;
	
	public ListaProdutorConsumidor4(int tamanho) {
		if (tamanho <= 0) {
			throw new IllegalArgumentException("Tamanho deve ser maior que zero(0).");
		}
		this.lista = new LinkedList<>();
		this.tamanho = tamanho;
		this.lock = new ReentrantReadWriteLock(true);
		this.readLock = this.lock.readLock();
		this.writeLock = this.lock.writeLock();
//		this.conditionRead = this.readLock.newCondition(); // erro
		this.conditionWrite = this.writeLock.newCondition();
	}
	
	public void escrever(T obj) {
		this.writeLock.lock();
		try {
//			while (this.lista.size() >= tamanho) {
//				try {
//					this.conditionWrite.await();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
			this.lista.offer(obj);
			this.imprimir();
//			this.conditionWrite.signalAll();
		} finally {
			this.writeLock.unlock();
		}
	}
	
	public T ler() {
		this.readLock.lock();
		T obj = null;
		try {
//			while (this.lista.size() <= 0) {
//				try {
//					this.conditionRead.await();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			if (size() <= 0) {
//				this.readLock.lock();
//				return null;
//			}
			obj = this.lista.poll();
			this.imprimir();
//			this.conditionRead.signalAll();
		} finally {
			this.readLock.lock();
		}
		return obj;
	}
	
	public int size() {
		int s = -1;
		this.readLock.lock();
		try {
			s = this.lista.size();
		} finally {
			this.readLock.unlock();
		}
		return s;
	}
	
	public void imprimir() {
		this.lista.stream().forEach(obj -> System.out.printf("%02d ", obj));
		System.out.printf("%n");
	}
}
