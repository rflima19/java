package com.lima;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectCreator {

	public static <T> T create(Class<T> clazz) 
			throws NoSuchMethodException, SecurityException, InstantiationException, 
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<T> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		T instance = constructor.newInstance();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			Init init = method.getAnnotation(Init.class);
			if (init != null) {
				boolean runOnInstantiation = init.runOnInstantiation();
				if (runOnInstantiation == true) {
					method.setAccessible(true);
					method.invoke(instance);
				}
			}
		}
		return instance;
	}
}
