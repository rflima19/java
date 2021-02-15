package lima.com;

import java.util.concurrent.ForkJoinPool;

public class AppFibonacci {

	public static void main(String[] args) {
		
		ForkJoinPool fjp = new ForkJoinPool();
		
		Fibonacci fibo = null;
		int n = 50;
		
		for (long i = 0; i < n; i++) {
			fibo = new Fibonacci(i);
			long result = fjp.invoke(fibo);
			System.out.printf("%d ", result);
		}
		
	}
}
