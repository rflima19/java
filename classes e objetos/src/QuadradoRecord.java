public record QuadradoRecord(double lado) {

	public QuadradoRecord() {
		this(0.0);
	}

//	construtor com os atributos é criado automaticamente	
//	public QuadradoRecord(double lado) {
//		this.lado = lado;
//	}

//	não pode declarar métodos set(), os atributos em tipos record são imutáveis, são final
//	public void setLado(double lado) {
//		if (lado >= 0.0) {
//			this.lado = lado;
//		}
//	}

//	métodos get são criados automaticamente, a sobrescrita dos métodos equals(), hashcode()
//	e toString() também é feita de forma automática

	public double calculaArea() {
		return this.lado * this.lado;
	}

// também é possivel criar métodos estáticos
}
