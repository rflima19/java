package lima.com;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class AppSomarArray {

	public static void main(String[] args) {
		int[] array = new int[10000000];
		Arrays.fill(array, 1);
		
		SomaElementosArray somador = new SomaElementosArray(array, 0, (array.length - 1));
		ForkJoinPool fjp = new ForkJoinPool();
		Integer resultado = fjp.invoke(somador);
		System.out.println("Resultado: " + resultado);
	}
}
