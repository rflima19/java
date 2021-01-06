package com.lima;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			// Class<Televisao> tvClazz = Televisao.class;
			@SuppressWarnings("unchecked")
			Class<Televisao> tvClazz = (Class<Televisao>) Class.forName("com.lima.Televisao");

			Field[] fields = tvClazz.getDeclaredFields();

			for (Field f : fields) {
				System.out.println(f.getName() + " => " + f.getType());
			}

			Method[] methods = tvClazz.getDeclaredMethods();

			for (Method m : methods) {
				System.out.println(
						m.getName() + " => " + m.getReturnType() + " => " + Arrays.toString(m.getParameters()));
			}

			Constructor<Televisao> constructor = tvClazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			Televisao tv = constructor.newInstance();
			Method mudarCanal = tvClazz.getDeclaredMethod("mudarCanal", int.class);
			mudarCanal.invoke(tv, 25);
			Method desligarTv = tvClazz.getDeclaredMethod("desligar");
			desligarTv.invoke(tv);

			
			
			Main.executar(new TestClass());

			
			
			String className = null;
			try (Scanner scanner = new Scanner(new File("class_name.txt"))) {
				className = scanner.nextLine();
			}
			@SuppressWarnings("unchecked")
			Class<? extends Bebida> bebidaClazz = (Class<? extends Bebida>) Class.forName(className);
			Constructor<? extends Bebida> c = bebidaClazz.getDeclaredConstructor();
			c.setAccessible(true);
			Bebida bebida = c.newInstance();
			Method metodoPreparar = bebidaClazz.getDeclaredMethod("preparar");
			metodoPreparar.invoke(bebida);
			
			
			TestClass testClass = ObjectCreator.<TestClass>create(TestClass.class);
			
			
			Pessoa p1 = new Pessoa();
			System.out.println(p1.toString());
			Property.<Pessoa, String>set(p1, "nome", "Vitória");
			Property.<Pessoa, Integer>set(p1, "idade", 23);
			System.out.println(p1.toString());

			Map<String, Object> map = new HashMap<>();
			map.put("nome", "Letícia");
			map.put("idade", 26);
			Pessoa p2 = Property.<Pessoa>set(Pessoa.class, map);
			System.out.println(p2);
			
			String nome = Property.get(p1, "nome", String.class);
			System.out.println(nome);
			Integer idade = Property.get(p2, "idade", Integer.class);
			System.out.println(idade);
			
			
			
			TestClass tc = ServiceFactory.newInstance(TestClass.class);
			tc.m2("test");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	public static <T extends TestClass> void executar(T myClass)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) myClass.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			Executar a = m.getAnnotation(Executar.class);
			if (a != null) {
				String param = a.arg();
				m.invoke(myClass, param);
			}
		}
	}
}
