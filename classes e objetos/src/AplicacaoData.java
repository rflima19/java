
public class AplicacaoData {

	public static void main(String[] args) {
		Data d1 = new Data(10, 3, 2000, 10, 30, 20);
		d1.imprimir(Data.FORMATO_12H);
		d1.imprimir(Data.FORMATO_24H);
		
		Data d2 = new Data(15, 6, 2000, 15, 15, 20);
		d2.imprimir(Data.FORMATO_12H);
		d2.imprimir(Data.FORMATO_24H);
		
		Data d3 = new Data(5, 10, 2005);
		d3.imprimir(Data.FORMATO_12H);
		d3.imprimir(Data.FORMATO_24H); 

	}
}
