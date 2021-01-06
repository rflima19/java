package com.lima;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		System.out.println("abc".getClass());
		
		System.out.println(int.class);
		
		System.out.println(ArrayList.class);
		
		Class<?> clazz = "abc".getClass();
		System.out.println(clazz.getPackageName());
		System.out.println(clazz.getSimpleName());
		System.out.println(Modifier.isPublic(clazz.getModifiers()));
		
		try {
			Class<?> c1 = Class.forName("java.lang.String");
			
			String s = (String) c1.getDeclaredConstructor(String.class).newInstance("JAVA");
			
			System.out.println(s);
			
			System.out.println(c1.isAssignableFrom(Integer.class));
			
			
			Class<Integer> c2 = Integer.class;
			System.out.println(c2.getName());
			Class[] tiposParametros = new Class[] {String.class};
			Constructor<Integer> construtor = c2.getConstructor(tiposParametros);
			construtor.setAccessible(true);
			Integer n = construtor.newInstance("90");
			System.out.println(n);
			construtor.setAccessible(false);
			
			// criando array por reflexão
			
			// Object[] array = (Object[]) Array.newInstance(Double.class, 10);
			// array[0] = 10.0;
			// System.out.println(Arrays.toString(array));
			
			Object array = Array.newInstance(double.class, 10);
			Array.setDouble(array, 0, 10.0);
			Array.setDouble(array, 1, 11.0);
			Array.setDouble(array, 2, 12.0);
			for (int i = 0; i < Array.getLength(array); i++) {
				System.out.println(Array.getDouble(array, i));
			}
			
			Object arrayObj = Array.newInstance(Double.class, 10);
			Array.set(arrayObj, 0, Double.valueOf(20.0));
			Array.set(arrayObj, 1, Double.valueOf(21.0));
			Array.set(arrayObj, 2, Double.valueOf(22.0));
			for (int i = 0; i < Array.getLength(arrayObj); i++) {
				System.out.println(Array.get(arrayObj, i));
			}
			
			Class<?> c3 = arrayObj.getClass();
			System.out.println(c3.isArray());
			
			
			Class<String> c4 = String.class;
			Field f1 = c4.getDeclaredField("hash");
			System.out.println(f1.getName());
			
			String str = new String("teste Field");
			Class<? extends String> c5 = str.getClass();
			Field f2 = c5.getDeclaredField("coder");
			f2.setAccessible(true);
			Object value = f2.get(str);
			System.out.println(value);
			f2.setAccessible(false);
			
			List<Integer> list = new ArrayList<>();
			list.add(10);
			list.add(20);
			Class<?> c6 = list.getClass();
			Field f3 = c6.getDeclaredField("size");
			f3.setAccessible(true);
			Object value2 = f3.get(list);
			System.out.println(value2);
			f3.setAccessible(false);
			
			Method[] mArray = c6.getDeclaredMethods();
			for (Method method : mArray) {
				System.out.println(method.getName() + " - " + method.getParameterCount());
			}
			
//			Method m1 = c6.getDeclaredMethod("add", new Class[] {Integer.class});
//			m1.setAccessible(true);
//			m1.invoke(list, new Object[] {Integer.valueOf(30)});
//			System.out.println(list.contains(30));
//			m1.setAccessible(false);			
			
			Method m1 = c6.getDeclaredMethod("clear", new Class[] {});
			m1.setAccessible(true);
			m1.invoke(list, new Object[] {});
			System.out.println(list.isEmpty());
			m1.setAccessible(false);
			
			
			Class<? super String> c7 = String.class;
			
			Class[] arrayInterfaces = c7.getInterfaces();
			for (Class c : arrayInterfaces) {
				System.out.println(c.getName());
			}
			
			while (c7 != null) {
				System.out.println(c7.getName());
				c7 = c7.getSuperclass();
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}
