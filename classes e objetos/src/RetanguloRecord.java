
public record RetanguloRecord(double largura, double altura) {

	public RetanguloRecord() {
		super();
		this.largura = 12.0;
		this.altura = 5.0;
		
//		this.altura = 9.0; uma vez definido um valor para o atributo não é possivel alterar
	}

	public double calculaArea() {
		return largura * altura;
	}
	
	public static RetanguloRecord create(double lado) {
		return new RetanguloRecord(lado, lado);
	}
}
