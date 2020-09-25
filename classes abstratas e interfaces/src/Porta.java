
public class Porta implements Cloneable {

	private double altura;
	private double largura;
	private boolean aberta;

	public Porta(double altura, double largura, boolean aberta) {
		super();
		this.altura = altura;
		this.largura = largura;
		this.aberta = aberta;
	}

	public double getAltura() {
		return altura;
	}

	public double getLargura() {
		return largura;
	}

	public boolean isAberta() {
		return aberta;
	}

	public void abrir() {
		this.aberta = true;
	}
	
	public void fechar() {
		this.aberta = false;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = new Porta(this.altura, this.largura, this.aberta);
		return obj;
	}

	@Override
	public String toString() {
		return "Porta[altura=" + this.altura + ",largura=" + this.largura + ",aberta=" + this.aberta + "]";
	}
	
	

}
