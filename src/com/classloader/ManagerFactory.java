package com.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ManagerFactory {
	// ��¼�ȼ�����ļ�����Ϣ
	private static final Map<String, LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();
	// Ҫ�������·��
	public static final String CLASS_PATH = "F:/myeclipsework/MyServletFirst/WebRoot/WEB-INF/classes/";
	// ʵ���ȼ������ȫ��������+������
	public static final String MY_MANAGER = "com.classloader.MyManager";

	public static BaseManager getManager(String className) {
		File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/")
				+ ".class");
		long lastModified = loadFile.lastModified();
		// loadTimeMap��������classNameΪkey��loadinfo��Ϣ��֤�������û�б����أ���Ҫ���ش���
		if (loadTimeMap.get(className) == null) {
			load(className, lastModified);
			// ���ش����ʱ��������仯�����¼��ش��ൽjvm
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

	// �Է���ķ�ʽ����BaseManager�Ӷ���
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
