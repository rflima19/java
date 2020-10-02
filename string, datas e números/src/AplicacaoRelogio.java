import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AplicacaoRelogio {
	public static void main(String[] args) {
		LocalTime time = null;
		// DateTimeFormatter formatador = DateTimeFormatter.ISO_TIME;
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss", new Locale("pt", "BR"));
		for (;;) {

			time = LocalTime.now();
			System.out.println(time.format(formatador));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
