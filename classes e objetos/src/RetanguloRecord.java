
public record RetanguloRecord(double largura, double altura) {

	public RetanguloRecord() {
		this(12.0, 5.0);
//		this.largura = 12.0;
//		this.altura = 5.0;
		
//		this.altura = 9.0; uma vez definido um valor para o atributo não é possivel alterar
	}
	
//	public RetanguloRecord(double a, double b) {
//		this.largura = a;
//		this.altura = b;
//		
////		this.altura = 9.0; uma vez definido um valor para o atributo não é possivel alterar
//	}

	public double calcularArea() {
		return largura * altura;
	}
	
	public static RetanguloRecord create(double lado) {
		return new RetanguloRecord(lado, lado);
	}
}
