package com.lima.generics;

public class AppMap {

	public static void main(String[] args) {
		Map<Integer, String> map = new Map<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		map.put(5, "E");
		map.put(6, "F");
		map.put(7, "G");
		map.put(8, "H");
		
		System.out.println(map);
		
		String str1 = map.get(4);
		System.out.println(str1);
		
		String str2 = map.get(2);
		System.out.println(str2);
		
		String str3 = map.get(20);
		System.out.println(str3);
		
		map.put(6, "NEW");
		System.out.println(map);
		
		map.remove(5);
		System.out.println(map);
		
		map.remove(1);
		System.out.println(map);
		
		map.clear();
		System.out.println(map);
	}
}
