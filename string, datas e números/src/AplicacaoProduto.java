import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class AplicacaoProduto {

	public static void main(String args[]) {

		Produto p1 = new Produto("Feijão", 2.5, LocalDate.of(2020, 11, 4));
		Produto p2 = new Produto("Café", 1.0, "01/02/2022");
		Produto p3 = new Produto("Beterraba", 0.9, 12, 12, 2017);
		
		System.out.printf("%d) %12s %,09.2f %td/%<tm/%<tY%n", 1, p1.getNome(), p1.getPeso(), p1.getValidade());
		
		DecimalFormat df = new DecimalFormat("000000.00");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
		String textoFormatado = String.format("%d) %12s %s %s%n", 2, p2.getNome(), df.format(p2.getPeso()), dtf.format(p2.getValidade()));
		System.out.print(textoFormatado);
		
		LocalDateTime ldt = LocalDateTime.of(p3.getValidade().getYear(), p3.getValidade().getMonth(), p3.getValidade().getDayOfMonth(), 0, 0);
		Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		System.out.printf("%d) %12s %,09.2f %td/%<tm/%<tY%n", 2, p3.getNome(), p3.getPeso(), date);
	}
}
