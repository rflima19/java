public record QuadradoRecord(double lado) {

	public QuadradoRecord() {
		this(0.0);
	}

//	construtor com os atributos � criado automaticamente	
//	public QuadradoRecord(double lado) {
//		this.lado = lado;
//	}

//	n�o pode declarar m�todos set(), os atributos em tipos record s�o imut�veis, s�o final
//	public void setLado(double lado) {
//		if (lado >= 0.0) {
//			this.lado = lado;
//		}
//	}

//	m�todos get s�o criados automaticamente, a sobrescrita dos m�todos equals(), hashcode()
//	e toString() tamb�m � feita de forma autom�tica

	public double calculaArea() {
		return this.lado * this.lado;
	}

// tamb�m � possivel criar m�todos est�ticos
}
