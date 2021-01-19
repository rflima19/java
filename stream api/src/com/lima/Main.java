package com.lima;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(Integer.valueOf(45));
		list1.add(Integer.valueOf(105));
		list1.add(Integer.valueOf(78));
		list1.add(Integer.valueOf(28));
		list1.add(Integer.valueOf(39));

		Main.<Integer>percorrerColecaoSemUtilizarStreamAPI(list1, e -> System.out.println(e));

		int soma = Main.somarSemUtilizarStreamAPI(list1, e -> e.intValue() % 2 == 0);
		System.out.println(soma);

		// Stream API

		Stream<Integer> stream1 = list1.stream();
		Stream<Integer> stream2 = Stream.of(Integer.valueOf(1), 2, 3, 4, 5); // criando stream a partir de valores
		IntStream stream3 = Arrays.stream(new int[] { 1, 2, 3, 4, 5 }); // criando stream a partir de um array

		Pessoa p1 = new Pessoa("p1", "Mario", "Alemanha", 32);
		Pessoa p2 = new Pessoa("p2", "Grabiela", "França", 20);
		Pessoa p3 = new Pessoa("p3", "Samara", "Portugal", 45);
		Pessoa p4 = new Pessoa("p4", "Venicius", "Canada", 16);
		Pessoa p5 = new Pessoa("p5", "Carlos", "Brasil", 52);
		Pessoa p6 = new Pessoa("p6", "Solange", "Angola", 25);
		Pessoa p7 = new Pessoa("p7", "Bianca", "Holanda", 34);
		Pessoa p8 = new Pessoa("p8", "Marina", "EUA", 21);
		Pessoa p9 = new Pessoa("p9", "Renata", "Alemanha", 18);
		Pessoa p10 = new Pessoa("p10", "João", "Holanda", 29);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);
		pessoas.add(p5);
		pessoas.add(p6);
		pessoas.add(p7);
		pessoas.add(p8);
		pessoas.add(p9);
		pessoas.add(p10);

		// operações intermediarias

		Stream<Pessoa> stream4 = pessoas.stream();
		Stream<Pessoa> streamResultFilter = stream4.filter((Pessoa p) -> {
			String nac = p.getNacionalidade();
			if (nac.equals("Brasil") == true) {
				return true;
			}
			return false;
		});
		Stream<Integer> streamResultMap = pessoas.stream().filter(p -> p.getNacionalidade().equals("Brasil") == true)
				.map(pessoa -> {
					return pessoa.getIdade();
				});
		Stream<Integer> streamResultMap2 = pessoas.stream().map(pessoa -> {
			return pessoa.getIdade();
		});
		IntStream streamResultIntStream = pessoas.stream().mapToInt(pessoa -> {
			return pessoa.getIdade();
		});

		Stream<Pessoa> streamResultSorted = pessoas.stream().sorted((Pessoa pessoa1, Pessoa pessoa2) -> {
			return pessoa1.getNome().compareTo(pessoa2.getNome());
		});
		Stream<Pessoa> streamResultSorted2 = pessoas.stream()
				.sorted(Comparator.comparing((Pessoa pessoa) -> pessoa.getNome()));

		Stream<Pessoa> streamResultDistinct = pessoas.stream().distinct();

		Stream<Pessoa> streamResultLimit = pessoas.stream().limit(2);

		// operações finais

		pessoas.stream().forEach(e -> System.out.println(e.getNome()));
		streamResultLimit.forEach(e -> System.out.println(e.getNome()));
		streamResultSorted2.forEach(e -> System.out.println(e.getNome()));

		double mediaIdade1 = pessoas.stream().mapToInt(p -> p.getIdade()).average().getAsDouble();
		double mediaIdade2 = pessoas.stream().filter(p -> p.getNacionalidade().equals("Brasil") == true)
				.mapToInt(p -> p.getIdade()).average().getAsDouble();
		System.out.println(mediaIdade1);
		System.out.println(mediaIdade2);

//		Collector<Pessoa, LinkedList<Pessoa>, LinkedList<Pessoa>> c = Collector.of(
//				LinkedList::new,
//				LinkedList::add, 
//				(a, b) -> {
//					LinkedList<Pessoa> list = new LinkedList<>();
//					list.addAll(a);
//					list.addAll(b);
//					return list;
//				}, null);
		Collector<Pessoa, LinkedList<Pessoa>, LinkedList<Pessoa>> consomerPersonal = Collector.of(() -> {
			return new LinkedList<Pessoa>(); // supplier
		}, (a, b) -> {
			a.add(b); // accumulator
		}, (a, b) -> {
			LinkedList<Pessoa> list = new LinkedList<>(); // combiner
			list.addAll(a);
			list.addAll(b);
			return list;
		});
		LinkedList<Pessoa> pessoasComS = pessoas.stream().filter((Pessoa p) -> (p.getNome().startsWith("S") == true))
				.collect(consomerPersonal);
		System.out.println(pessoasComS);
		
		List<Pessoa> pessoasComM = pessoas.stream().filter((Pessoa p) -> (p.getNome().startsWith("M") == true))
				.collect(Collectors.toList());
		pessoasComM.stream().forEach(e -> System.out.println(e.getNome()));

		String joined = pessoas.stream().map(p -> p.getNome()).collect(Collectors.joining(", "));
		System.out.println(joined);

		long qtdPessoas = pessoas.stream().count();
		System.out.println(qtdPessoas);

		boolean todosCanadenses = pessoas.stream().allMatch(p -> p.getNacionalidade().equals("Canada") == true);
		boolean todosMaiorIdade15 = pessoas.stream().allMatch(p -> p.getIdade() > 15 == true);
		boolean algumMaiorIdade15 = pessoas.stream().anyMatch(p -> p.getIdade() > 15 == true);
		boolean nenhumMaiorIdade15 = pessoas.stream().noneMatch(p -> p.getIdade() > 15 == true);
		System.out.println(todosCanadenses);
		System.out.println(todosMaiorIdade15);
		System.out.println(algumMaiorIdade15);
		System.out.println(nenhumMaiorIdade15);

		// pessoas.stream().mapToInt(p -> p.getIdade()).max().getAsInt();
		Pessoa pessoaMaisVelha = pessoas.stream().max(Comparator.comparingInt(p -> p.getIdade())).get();
		Pessoa pessoaMaisNova = pessoas.stream().min(Comparator.comparingInt(p -> p.getIdade())).get();
		System.out.println(pessoaMaisVelha.getNome() + " - " + pessoaMaisVelha.getIdade());
		System.out.println(pessoaMaisNova.getNome() + " - " + pessoaMaisNova.getIdade());

		// testando stream API

		List<Integer> list5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> listElevadoAoQuadrado = list5.stream().filter(n -> {
			System.out.println("filter - " + n);
			return n.intValue() % 2 == 0;
		}).map(n -> {
			System.out.println("map - " + n);
			return n * n;
		}).limit(3).collect(Collectors.toList());
		listElevadoAoQuadrado.forEach(System.out::println);

		List<Integer> list6 = list5.stream().skip(3).collect(Collectors.toList());
		list6.forEach(System.out::println);
		
		List<String> numeros = new ArrayList<>();
		numeros.add("5");
		numeros.add("31");
		numeros.add("22");
		numeros.add("14");
		numeros.add("9");
		numeros.add("30");
		numeros.add("18");
		int soma2 = numeros.stream()
				.mapToInt(Integer::parseInt)
				.sum();
		long soma3 = numeros.stream()
				.collect(Collectors.summarizingInt(Integer::parseInt))
				.getSum();
		System.out.println("Soma2 = " + soma2);
		System.out.println("Soma3 = " + soma3);
		

		// int sum = list5.stream().mapToInt(Integer::intValue).sum();
		int sum = list5.stream().reduce(0, (Integer n1, Integer n2) -> (n1 + n2));
		System.out.println(sum);

		IntStream range10A29 = IntStream.range(10, 30);
		IntStream range10A30 = IntStream.rangeClosed(10, 30);
		IntStream rangeImpar10A30 = IntStream.rangeClosed(10, 30).filter(n -> n % 2 != 0);
		range10A29.forEach(System.out::println);
		range10A30.forEach(System.out::println);
		rangeImpar10A30.forEach(System.out::println);

		Map<Integer, String> mapIdadeNome = pessoas.stream()
				.collect(Collectors.<Pessoa, Integer, String>toMap(p -> p.getIdade(), p -> p.getNome()));
		System.out.println(mapIdadeNome);
		
		Map<String, List<Pessoa>> agrupaPessoaPorNacionalidade = pessoas.stream()
				.collect(Collectors.<Pessoa, String>groupingBy(p -> p.getNacionalidade()));
		System.out.println(agrupaPessoaPorNacionalidade);
		
		// paralelismo na Stream API

		List<Integer> list7 = IntStream.rangeClosed(0, 15000000).boxed().collect(Collectors.toList());

		List<Integer> listNumerosPares = list7.parallelStream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		long qtd = listNumerosPares.stream().count();
		System.out.println("-> " + qtd);

		// Streams infinitas

		// Stream.iterate(0, e -> e + 10).forEach(System.out::println);
		Stream.iterate(0, e -> e + 10).limit(100).forEach(System.out::println);

//		Stream.generate(() -> {
//			return Math.random() * 10;
//		}).forEach(System.out::println);
		Stream.generate(() -> {
			return Math.random() * 10;
		}).limit(10).forEach(System.out::println);

	}

	public static <T> void percorrerColecaoSemUtilizarStreamAPI(Collection<T> collection, Consumer<T> consumer) {
		Iterator<T> iterator = collection.iterator();
		while (iterator.hasNext() == true) {
			T obj = iterator.next();
			// System.out.println(obj);
			consumer.accept(obj);
		}
	}

	public static Integer somarSemUtilizarStreamAPI(Collection<Integer> collection, Predicate<Integer> predicate) {
		Iterator<Integer> iterator = collection.iterator();
		Integer soma = Integer.valueOf(0);
		while (iterator.hasNext() == true) {
			Integer i = iterator.next();
			if (predicate.test(i) == true) {
				soma = soma + i;
			}
		}
		return soma;
	}

}
