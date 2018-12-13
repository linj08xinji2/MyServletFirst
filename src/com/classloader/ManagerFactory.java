package com.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ManagerFactory {
	// 记录热加载类的加载信息
	private static final Map<String, LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();
	// 要加载类的路径
	public static final String CLASS_PATH = "F:/myeclipsework/MyServletFirst/WebRoot/WEB-INF/classes/";
	// 实现热加载类的全名（包名+类名）
	public static final String MY_MANAGER = "com.classloader.MyManager";

	public static BaseManager getManager(String className) {
		File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/")
				+ ".class");
		long lastModified = loadFile.lastModified();
		// loadTimeMap不包含以className为key的loadinfo信息，证明这个类没有被加载，需要加载此类
		if (loadTimeMap.get(className) == null) {
			load(className, lastModified);
			// 加载此类的时间戳发生变化，重新加载此类到jvm
		} else if (loadTimeMap.get(className).getLoadTime() != lastModified) {
			load(className, lastModified);
		}
		return loadTimeMap.get(className).getManager();
	}

	private static void load(String className, long lastModified) {
		MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
		Class<?> loadClass = null;
		try {
			loadClass = myClassLoader.loadClass(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		BaseManager manager = newInstance(loadClass);
		LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
		loadInfo.setManager(manager);
		loadTimeMap.put(className, loadInfo);
	}

	// 以反射的方式创建BaseManager子对象
	private static BaseManager newInstance(Class<?> loadClass) {
		try {
			return (BaseManager) loadClass.getConstructor(new Class[] {})
					.newInstance(new Object[] {});
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
		}
		return null;
	}
}
