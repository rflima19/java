package com.lima.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AppSearchCollection {

	public static void main(String[] args) {
		OodInteger p1 = new OodInteger();
		EvenInteger p2 = new EvenInteger();
		PrimeNumber p3 = new PrimeNumber();
		PalindromeNumber p4 = new PalindromeNumber();
		
		OodInteger2 p5 = new OodInteger2();
		EvenInteger2 p6 = new EvenInteger2();
		PrimeNumber2 p7 = new PrimeNumber2();
		PalindromeNumber2 pal = new PalindromeNumber2();
		
		List<Integer> li = new ArrayList<>();
		LinkedList<Integer> palindromes = new LinkedList<>();
		Set<Double> sd = new HashSet<>();
		Set<Number> sn = new HashSet<>();
		
		for (int i = 0; i <= 100; i++) {
			li.add(Integer.valueOf(i));
			sd.add(Double.valueOf(i));
			// sn.add(Double.valueOf(i));
		}
		
		palindromes.add(212);
		palindromes.add(532);
		palindromes.add(98);
		palindromes.add(3003);
		palindromes.add(12);
		palindromes.add(456654);
		palindromes.add(529);
		palindromes.add(8888888);
		
		sn.add(555);
		sn.add(209);
		sn.add(101);
		
		System.out.println("Count ood numbers: " + SearchCollection.<OodInteger>countByProperty(li, p1));
		System.out.println("Count even numbers: " + SearchCollection.<EvenInteger>countByProperty(sd, p2));
		System.out.println("Count prime numbers: " + SearchCollection.countByProperty(li, p3));
		System.out.println("Count numbers palindromes: " + SearchCollection.countByProperty(palindromes, p4));
		
		System.out.println("Count ood numbers: " + SearchCollection.<Integer>countByProperty2(li, p5));
		System.out.println("Count even numbers: " + SearchCollection.<Integer>countByProperty2(li, p6));
		System.out.println("Count prime numbers: " + SearchCollection.countByProperty2(li, p7));
		System.out.println("Count numbers palindromes: " + SearchCollection.<Number>countByProperty2(sn, pal));
		
		List<Integer> l1 = new ArrayList<>();
		l1.add(56);
		l1.add(13);
		l1.add(95);
		l1.add(45);
		
		List<String> l2 = new ArrayList<String>();
		l2.add("list");
		l2.add("dog");
		l2.add("cat");
		l2.add("generics");
		l2.add("java");
		l2.add("cat");
		l2.add("girls");
		
		Integer i = SearchCollection.<Integer>maxElementRanger(l1, 0, 3);
		String s = SearchCollection.<String>maxElementRanger(l2, 2, 5);
		
		System.out.println(i);
		System.out.println(s);
	}
}
