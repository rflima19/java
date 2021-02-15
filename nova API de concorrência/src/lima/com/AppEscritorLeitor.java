package lima.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppEscritorLeitor {

	public static void main(String[] args) {
		Info info = new Info();
		
		ExecutorService e = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 5; i++) {
			Leitor l = new Leitor(info, "leitor" + i);
			e.execute(l);
		}
		
		for (int i = 0; i < 5; i++) {
			Escritor escr = new Escritor(info);
			e.execute(escr);
		}
		
		e.shutdown();
	}
}
