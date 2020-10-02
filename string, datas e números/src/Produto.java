import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Produto {
	
	private String nome;
	private double peso;
	private LocalDate validade;
	
	public Produto(String nome, double peso, LocalDate validade) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.validade = validade;
	}
	
	public Produto(String nome, double peso, String validade) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.validade = LocalDate.parse(validade, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public Produto(String nome, double peso, int dia, int mes, int ano) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.validade = LocalDate.of(ano, mes, dia);
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public LocalDate getValidade() {
		return validade;
	}
	
}
