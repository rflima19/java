package com.lima.generics;

public class Box<T> {

	private T object;
	
	public Box(T object) {
		super();
		this.object = object;
	}
	
	public T getObject() {
		return this.object;
	}
	
	public void setObject(T object) {
		this.object = object;
	}
	
	public static void main(String[] args) {
		Box<String> box1 = new Box<>(new String("ABC"));
		Box<Integer> box2 = new Box<>(Integer.valueOf(30));
		
		String str = box1.getObject();
		
		System.out.println(str);
		
		box2.setObject(50);
		
		int var = box2.getObject();
		
		System.out.println(var);
	}
}
