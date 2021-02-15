package lima.com;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	private long num;

	public Fibonacci(long num) {
		super();
		this.num = num;
	}

	@Override
	protected Long compute() {
		if (this.num <= 1) {
			return this.num;
		}
		Fibonacci f1 = new Fibonacci(this.num - 1);
		f1.fork();
		Fibonacci f2 = new Fibonacci(this.num - 2);
		return f2.compute() + f1.join();
	}
}
