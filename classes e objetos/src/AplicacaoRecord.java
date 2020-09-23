public class AplicacaoRecord {
	
	public static void main(String[] args) {
		QuadradoRecord q1 = new QuadradoRecord(6);
		System.out.println(q1.calcularArea());
		System.out.println(q1);
		
		QuadradoRecord q2 = new QuadradoRecord(6);
		System.out.println(q2.calcularArea());
		System.out.println(q2.equals(q1));
		
		RetanguloRecord r1 = new RetanguloRecord(50.0, 75.0);
		System.out.println(r1.altura()); // chamando método get
		System.out.println(r1.largura()); // chamando método get
		System.out.println(r1.calcularArea());
		
		RetanguloRecord r2 = RetanguloRecord.create(10.0);
		System.out.println(r2.altura()); // chamando método get
		System.out.println(r2.largura()); // chamando método get
	}
}
