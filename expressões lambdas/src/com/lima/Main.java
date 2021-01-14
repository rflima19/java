package com.lima;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
//		Pessoa p1 = new Pessoa("Leandro", LocalDate.of(1995, 4, 15), Pessoa.Sexo.MASCULINMO, "leandro@gmail.com");
//		p1.imprimir();
//		System.out.println(p1.getIdade());

		Pessoa p1 = new Pessoa("Leandro", LocalDate.of(1995, 4, 15), Pessoa.Sexo.MASCULINMO, "leandro@gmail.com");
		Pessoa p2 = new Pessoa("Nayara", LocalDate.of(1998, 2, 2), Pessoa.Sexo.FEMININO, "nayara@gmail.com");
		Pessoa p3 = new Pessoa("Vanessa", LocalDate.of(2010, 6, 25), Pessoa.Sexo.FEMININO, "vanessa@gmail.com");
		Pessoa p4 = new Pessoa("João", LocalDate.of(2011, 8, 13), Pessoa.Sexo.MASCULINMO, "jjoao@gmail.com");
		Pessoa p5 = new Pessoa("Ándre", LocalDate.of(1994, 1, 7), Pessoa.Sexo.MASCULINMO, "andree@gmail.com");
		Pessoa p6 = new Pessoa("Carlos", LocalDate.of(1967, 3, 16), Pessoa.Sexo.MASCULINMO, "carlos@gmail.com");
		Pessoa p7 = new Pessoa("Carol", LocalDate.of(2001, 9, 29), Pessoa.Sexo.FEMININO, "carol@gmail.com");
		Pessoa p8 = new Pessoa("Letícia", LocalDate.of(1995, 10, 17), Pessoa.Sexo.FEMININO, "leticia@gmail.com");

		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);
		pessoas.add(p5);
		pessoas.add(p6);
		pessoas.add(p7);
		pessoas.add(p8);

		// Main.imprimir(pessoas, new ChecaPessoaServicoMilitar());

//		Main.imprimir(pessoas, new ChecaPessoa() {
//			
//			@Override
//			public boolean test(Pessoa pessoa) {
//				return (pessoa.getGenero() == Pessoa.Sexo.MASCULINMO) && 
//						((pessoa.getIdade() >= 18) && (pessoa.getIdade() <= 25)) ;
//			}
//		});

//		Main.imprimir(pessoas, (Pessoa p) -> {
//			return (p.getGenero() == Pessoa.Sexo.MASCULINMO) && 
//					((p.getIdade() >= 18) && (p.getIdade() <= 25));
//		});

		Main.imprimir(pessoas,
				p -> (p.getGenero() == Pessoa.Sexo.MASCULINMO) && ((p.getIdade() >= 18) && (p.getIdade() <= 25)));

		Main.imprimirComPredicate(pessoas,
				p -> (p.getGenero() == Pessoa.Sexo.MASCULINMO) && ((p.getIdade() >= 18) && (p.getIdade() <= 25)));

		Main.processarPessoas(pessoas, (Pessoa p) -> {
			return (p.getGenero() == Pessoa.Sexo.MASCULINMO) && ((p.getIdade() >= 18) && (p.getIdade() <= 25));
		}, (Pessoa p) -> {
			p.imprimir();
		});

		Main.processarPessoas(pessoas,
				p -> (p.getGenero() == Pessoa.Sexo.MASCULINMO) && ((p.getIdade() >= 18) && (p.getIdade() <= 25)),
				p -> p.imprimir());

		Main.processarPessoas2(pessoas, (Pessoa p) -> (p.getGenero() == Pessoa.Sexo.FEMININO),
				(Pessoa p) -> p.getEmail(), (String s) -> System.out.println(s));

		Main.processarPessoas2(pessoas, (Pessoa p) -> (p.getIdade() >= 18), (Pessoa p) -> p.getNome(),
				System.out::println);

		Double result1 = Calculadora.<Double>calcular(Double.valueOf(100), Double.valueOf(100),
				(Double n1, Double n2) -> n1 * n2);
		System.out.println(result1);

		Integer result2 = Calculadora.<Integer>calcular(Integer.valueOf(21), Integer.valueOf(67),
				(Integer n1, Integer n2) -> {
					return n1 + n2;
				});
		System.out.println(result2);

		Integer result3 = Calculadora.<Integer>calcularBinaryOperator(Integer.valueOf(54), Integer.valueOf(6),
				(n1, n2) -> (n1 / n2));
		System.out.println(result3);

		Runnable r = () -> {
			System.out.print("New Thread: expression lambda. - ");
			System.out.println(Thread.currentThread().getName());
		};
		Thread t = new Thread(r, "thread02");
		t.start();

		
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(9);
		list2.add(4);
		list2.add(7);
		list2.add(5);
		list2.add(6);
		list2.add(10);
		
		// list2.forEach(e -> System.out.println(e));

		list2.sort((e1, e2) -> {
			return e1.compareTo(e2);
		});
			
		list2.removeIf(e -> e % 2 != 0);
		
		list2.replaceAll(e -> e * 2);

		list2.forEach(System.out::println);

		
		
		Pessoa p9 = new Pessoa("Duda", LocalDate.of(1995, 7, 15), Pessoa.Sexo.FEMININO, "duda@gmail.com");
		p9.setIdade(62);
		p9.imprimir();
		double fator = p9.calcularFator();
		System.out.println("fator = " + fator);
		
		
		List<Integer> list3 = new ArrayList<>();
		list3.add(1);
		list3.add(-2);
		list3.add(-3);
		list3.add(4);
		list3.add(5);
		list3.add(-6);
		list3.add(7);
		list3.add(8);
		Function<Integer, Integer> f1 = e -> e * 2;
		Function<Integer, Integer> f2 = e -> e * -1;
		try {
			List<Integer> list4 = Main.transform(list3, f1);
			List<Integer> list5 = Main.transform(list3, f2);
			
			list3.forEach(System.out::println);
			list4.forEach(System.out::println);
			list5.forEach(System.out::println);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | 
				InvocationTargetException | NoSuchMethodException | SecurityException e3) {
			e3.printStackTrace();
		}
		
		
		List<String> list6 = new ArrayList<>();
		list6.add("abc");
		list6.add("Raquel");
		list6.add("Marcela");
		List<Double> list7 = new ArrayList<>();
		list7.add(1.5);
		list7.add(2.9);
		list7.add(17.3);
		Function<String, String> f4 = e -> e.toUpperCase();
		Function<Double, Double> f5 = e -> Math.floor(e);
		try {
			List<String> list8 = Main.transform2(list6, f4);
			List<Double> list9 = Main.transform2(list7, f5);
			
			list8.forEach(System.out::println);
			list9.forEach(System.out::println);
//			list9.forEach(new Consumer<Double>() {
//				@Override
//				public void accept(Double t) {
//				}
//			});
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | 
				InvocationTargetException | NoSuchMethodException | SecurityException e3) {
			e3.printStackTrace();
		}
		
		
		
		for (int i = 0; i < 10; i++) {
			  final int j = i;
			  Runnable ra = () -> System.out.println(j);	
			  ra.run();
		}
		
		
		
		Consumer<String> processor = msg -> {
			System.out.println(msg);
		};
		processor.accept("Java");


	}

	public static void imprimir(List<Pessoa> pessoas, ChecaPessoa check) {
		for (Pessoa pessoa : pessoas) {
			if (check.test(pessoa) == true) {
				pessoa.imprimir();
			}
		}
	}

	public static void imprimirComPredicate(List<Pessoa> pessoas, Predicate<Pessoa> check) {
		for (Pessoa pessoa : pessoas) {
			if (check.test(pessoa) == true) {
				pessoa.imprimir();
			}
		}
	}

	public static void processarPessoas(List<Pessoa> pessoas, Predicate<Pessoa> check, Consumer<Pessoa> process) {
		for (Pessoa pessoa : pessoas) {
			if (check.test(pessoa) == true) {
				process.accept(pessoa);
			}
		}
	}

	public static void processarPessoas2(List<Pessoa> pessoas, Predicate<Pessoa> check, Function<Pessoa, String> transf,
			Consumer<String> process) {
		for (Pessoa pessoa : pessoas) {
			if (check.test(pessoa) == true) {
				String email = transf.apply(pessoa);
				process.accept(email);
			}
		}
	}
	
	public static List<Integer> transform(List<Integer> list, Function<Integer, Integer> func) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, NoSuchMethodException, SecurityException {
		@SuppressWarnings("unchecked")
		List<Integer> newList = list.getClass().getDeclaredConstructor().newInstance();
		list.forEach(e -> {
			Integer i = func.apply(e);
			newList.add(i);
		});
		return newList;
	}
	
	public static <T> List<T> transform2(List<T> list, Function<T, T> func) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, NoSuchMethodException, SecurityException {
		@SuppressWarnings("unchecked")
		List<T> newList = list.getClass().getDeclaredConstructor().newInstance();
		list.forEach(e -> {
			T i = func.apply(e);
			newList.add(i);
		});
		return newList;
	}
}
