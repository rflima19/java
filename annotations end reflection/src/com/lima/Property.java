package com.lima;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

public class Property {
	
	public static <T> T set(Class<T> clazz, Map<String, ? extends Object> mapFieldValue) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, NoSuchMethodException, SecurityException {
		if (clazz == null) {
			throw new IllegalArgumentException("Object is null.");
		}
		
		Constructor<T> constructor = clazz.getDeclaredConstructor();
		T object = constructor.newInstance();
		
		Method method = null;
		Iterator<?> iterator = mapFieldValue.entrySet().iterator();
		while (iterator.hasNext() == true) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) iterator.next();
			String nameField = (String) entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				throw new IllegalArgumentException("Value is null.");
			}
			if (nameField.trim().isEmpty() == true) {
				throw new IllegalArgumentException("Name field is illegal.");
			}
			String nameMethodSet = Property.generateNameMethod(nameField, "set");
			method = clazz.getDeclaredMethod(nameMethodSet, value.getClass());
			method.setAccessible(true);
			method.invoke(object, value);
		}

		return object;
	}
	
	public static <T, S> void set(T object, String nameField, S value) 
			throws NoSuchFieldException, SecurityException, NoSuchMethodException, 
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (object == null) {
			throw new IllegalArgumentException("Object is null.");
		}
		if (value == null) {
			throw new IllegalArgumentException("Value is null.");
		}
		if (nameField.trim().isEmpty() == true) {
			throw new IllegalArgumentException("Name field is illegal.");
		}
		String nameMethodSet = Property.generateNameMethod(nameField, "set");
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) object.getClass();
		// Field field = clazz.getDeclaredField(nameField);
		Method method = clazz.getDeclaredMethod(nameMethodSet, value.getClass());
		method.setAccessible(true);
		method.invoke(object, value);
	}
	
	public static <T, S> S get(T object, String nameField, Class<S> typeReturn) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (object == null) {
			throw new IllegalArgumentException("Object is null.");
		}
		if (typeReturn == null) {
			throw new IllegalArgumentException("Type return is null.");
		}
		if (nameField.trim().isEmpty() == true) {
			throw new IllegalArgumentException("Name field is illegal.");
		}
		String nameMethodSet = Property.generateNameMethod(nameField, "get");
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) object.getClass();
		Method method = clazz.getDeclaredMethod(nameMethodSet);
		method.setAccessible(true);
		@SuppressWarnings("unchecked")
		S result = (S) method.invoke(object);
		return result;
	}
	
	private static String generateNameMethod(String nameField, String prefix) {
		StringBuilder strb = new StringBuilder(prefix.toLowerCase());
		char[] chars = nameField.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i == 0) {
				strb.append(Character.toUpperCase(chars[i]));
			} else {
				strb.append(Character.toLowerCase(chars[i]));
			}
		}
		return strb.toString();
	}
}
