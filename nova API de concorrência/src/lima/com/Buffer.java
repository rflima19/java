package lima.com;

public interface Buffer<T> {

	public abstract T ler();
	public abstract void escrever(T obj);
	public abstract void imprimir();
}
