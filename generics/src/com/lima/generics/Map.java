package com.lima.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Map<K, V> {

	private List<K> keys;
	private List<V> values;
	
	public Map() {
		super();
		this.keys = new ArrayList<>();
		this.values = new ArrayList<>();
	}
	
	public boolean put(K key, V value) {
		int index = this.keys.indexOf(key);
		if (index == -1) {
			this.keys.add(key);
			this.values.add(value);
			return true;
		}
		this.values.set(index, value);
		return false;
	}
	
	public V get(K key) {
		int index = this.keys.indexOf(key);
		if (index != -1) {
			return this.values.get(index);
		}
		return null;
	}
	
	public V remove(K key) {
		int index = this.keys.indexOf(key);
		if (index != -1) {
			V element = this.values.get(index);
			this.keys.remove(index);
			this.values.remove(index);
			return element;
		}
		return null;
	}
	
	public void clear() {
		this.keys.clear();
		this.values.clear();
	}
	
	@Override
	public String toString() {
		return this.mapToString(this.keys) + this.mapToString(this.values);
	}
	
	private String mapToString(List<?> list) {
		StringBuilder strb = new StringBuilder();
		strb.append("[");
		Iterator<?> itarator = list.iterator();
		while (true) {
			try {
				Object element = itarator.next();
				strb.append(element);
				if (itarator.hasNext() == true) {
					strb.append(", ");
				}
			} catch (NoSuchElementException e) {
				break;
			}
		}
		strb.append(String.format("%s%n", "]"));
		return strb.toString();
	}
}
