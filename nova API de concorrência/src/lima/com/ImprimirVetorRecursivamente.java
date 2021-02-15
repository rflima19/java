package lima.com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Imprime array recursivamente utilizando recurso ExecutorService
 * */
public class ImprimirVetorRecursivamente implements Callable<Void> {

	private int[] array;
	private ExecutorService executor;
	
	public ImprimirVetorRecursivamente(int[] array, ExecutorService executor) {
		super();
		this.array = array;
		this.executor = executor;
	}
	
	@Override
	public Void call() throws Exception {
		if (this.array.length > 0) {
			System.out.println(this.array[0]);
			int[] newArray = new int[this.array.length - 1];
			System.arraycopy(this.array, 1, newArray, 0, this.array.length - 1);
			Future<?> f = this.executor.submit(new ImprimirVetorRecursivamente(newArray, executor));
			f.get();
		}
		return null;
	}
}
