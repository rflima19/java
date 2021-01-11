package lima.com;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String varLocal = "123";
		// varLocal = "456";

		class Texto {
			private String texto;

			public Texto(String t) {
				super();
				this.texto = t;
			}

			public void imprimir1() {
				System.out.println(this.texto);
			}

			public void imprimir2(final String texto) {
				// texto = "";
				System.out.println(texto);
				System.out.println(varLocal);
			}
		}

		Texto t = new Texto("abc");
		t.imprimir1();
		t.imprimir2("def");

		
		
		Bebida cha = new Bebida() {
			@Override
			public void preparar() {
				System.out.println("Preparou o chá.");
				System.out.println(varLocal);
			}
		};

		Bebida cafe = new Bebida() {
			@Override
			public void preparar() {
				System.out.println("Preparou o café.");
				System.out.println(varLocal);
			}
		};

		cha.preparar();
		cafe.preparar();
		
		
		
		List<Integer> listaInteiro = new LinkedList<>();
		listaInteiro.add(33);
		listaInteiro.add(189);
		listaInteiro.add(35);
		listaInteiro.add(676);
		listaInteiro.add(297);
		listaInteiro.add(824);
		listaInteiro.add(6);
		
		class OrdenadorCrescenteLocalClass implements Comparator<Integer> {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		}
		
//		listaInteiro.sort(new Comparator<Integer>() {
//			public int compare(Integer o1, Integer o2) {
//				return o1.compareTo(o2);
//			};
//		});
		
//		listaInteiro.sort(new OrdenadorCrescenteLocalClass());
		
		listaInteiro.sort(new OrdenadorCrescenteStaticClass());
		
		for (Integer integer : listaInteiro) {
			System.out.println(integer.intValue());
		}
		
		
		
		Carro carro = new Carro();
		carro.ligarMotor();
		System.out.println(carro.isLigado());
	}
	
	static class OrdenadorCrescenteStaticClass implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	}
	
}
