package lima.com;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		// ExecutorService
		
//		ExecutorService exec1 = Executors.newCachedThreadPool();
//		for (int i = 0; i < 10; i++) {
//			exec1.execute(new Runnable() {
//				@Override
//				public void run() {
//					Random r = new Random();
//					try {
//						Thread.sleep(r.nextInt(10) * 100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getId() + " : " + Thread.currentThread().getName());
//				}
//			});
//		}
//		exec1.shutdown();
//
		int nucleos = Runtime.getRuntime().availableProcessors();
//		System.out.println("Quantidade de núcleos do processador: " + nucleos);
//
//		long qtdMemoria = Runtime.getRuntime().totalMemory();
//		System.out.println("Quantidade de mémoria disponivel para JVM em bytes: " + qtdMemoria);
//
//		long qtdMemoria2 = Runtime.getRuntime().maxMemory();
//		System.out.println("Quantidade máxima de mémoria disponivel para JVM usar em bytes: " + qtdMemoria2);
//		
		
//		ExecutorService exec2 = Executors.newFixedThreadPool(nucleos);
//		for (int i = 0; i < 10; i++) {
//			exec2.execute(new Escritor(10, "ABC" + i));
//		}
//		exec2.shutdown();
		
//		ScheduledExecutorService exec3 = Executors.newScheduledThreadPool(nucleos);
//		// exec3.schedule(() -> System.out.println("Thread agendada."), 4L, TimeUnit.SECONDS);
//		exec3.scheduleWithFixedDelay(() -> System.out.println("Thread agendada."), 4L, 4L, TimeUnit.SECONDS);
//		// exec3.shutdown();
		
		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		ExecutorService exec4 = Executors.newCachedThreadPool();
		Future<?> f = exec4.submit(new ImprimirVetorRecursivamente(array, exec4));
		try {
			f.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		exec4.shutdown();
		
		// ThreadPoolExecutor
		
		ExecutorService exec5 = new ThreadPoolExecutor(
				4, 
				8, 
				10000, 
				TimeUnit.MILLISECONDS, 
				new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < 10; i++) {
			exec5.execute(new Runnable() {
				@Override
				public void run() {
					Random r = new Random();
					try {
						Thread.sleep(r.nextInt(10) * 100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getId() + " : " + Thread.currentThread().getName());
				}
			});
		}
		exec5.shutdown();
		
		// ExecutorCompletionService
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(new Random().nextInt(10) * 1000);
				return Thread.currentThread().getName();
			}
		};
		ExecutorService exec6 = Executors.newCachedThreadPool();
		ExecutorCompletionService<String> ecs = new ExecutorCompletionService<>(exec6);
		int qtdTarefas = 3;
		for (int i = 0; i < qtdTarefas; i++) {
			ecs.submit(callable);
		}
		System.out.println("Tarefas iniciadas. Aguardando a conclusão.");
		for (int i = 0; i < qtdTarefas; i++) {
			try {
				System.out.println("Tarefa finalizada: " + ecs.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		exec6.shutdown();
		
		// ForkJoinPool
		
		ForkJoinPool fjp = new ForkJoinPool();
		Fibonacci fibo = new Fibonacci(40);
		Long result = fjp.invoke(fibo);
		System.out.println(result.longValue());
		
		
		// Var Atomic
		
		ExecutorService exec7 = Executors.newCachedThreadPool();
		Contador cont = new Contador();
		Incrementador[] increments = new Incrementador[100];
		for (int i = 0; i < increments.length; i++) {
			increments[i] = new Incrementador(cont);
			exec7.execute(increments[i]);
		}
		exec7.shutdown();
		
		
	}

}
