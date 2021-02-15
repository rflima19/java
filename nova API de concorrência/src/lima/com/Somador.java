package lima.com;

import java.util.concurrent.Callable;

public class Somador implements Callable<Integer> {

	private Integer n1;
	private Integer n2;

	public Somador(Integer n1, Integer n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override
	public Integer call() throws NumeroNegativo {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (this.n1 < 0.0 || this.n2 < 0.0) {
			throw new NumeroNegativo("Numero negativo.");
		}
		return this.n1 + this.n2;
	}
}
