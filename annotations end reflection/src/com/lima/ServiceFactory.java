package com.lima;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ServiceFactory {

	public static <T extends Service> T newInstance(Class<T> clazz) 
			throws NoSuchMethodException, SecurityException, InstantiationException, 
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<T> c = clazz.getDeclaredConstructor();
		T instance = c.newInstance();
		return instance;
	}
}
