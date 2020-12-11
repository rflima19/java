package com.lima.generics;

import java.util.Collection;
import java.util.List;

public class SearchCollection {
	
	public static <N extends Number & Comparable<N>> int countGreaterThan(Collection<N> collection, N number) {
		int count = 0;
		for (N num : collection) {
			if (number.compareTo(num) < 0) {
				count += 1;
			}
		}
		return count;
	}

	/**
	 * method to count the number of elements in a collecAon that have a specific property
	 * */
	public static <T extends SearchPropertyNumber> int countByProperty(Collection<? extends Number> collection, T property) {
		int count = 0;
		for (Number number : collection) {
			boolean test = property.filter(number);
			if (test == true) {
				count += 1;
			}
		}
		return count;
	}
	
	public static <N extends Number> int countByProperty2(Collection<N> collection, SearchPropertyNumber2<N> property) {
		int count = 0;
		for (N number : collection) {
			boolean test = property.filter(number);
			if (test == true) {
				count += 1;
			}
		}
		return count;
	}
	
	public static <E extends Comparable<E>> E maxElementRanger(List<E> list, int start, int end) {
		int sizeList = list.size();
		if (start < 0) {
			throw new IllegalArgumentException("start < 0");
		}
		if (end >= sizeList) {
			throw new IllegalArgumentException("end >= " + sizeList);
		}
		if (end < start) {
			throw new RuntimeException("end < start");
		}
		
		E maxElement = list.get(start);
		for (int i = start + 1; i <= end; i++) {
			E element = list.get(i);
			if (element.compareTo(maxElement) > 0) {
				maxElement = element;
			}
		}
		return maxElement;
	}
}
