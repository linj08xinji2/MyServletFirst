package com.classloader;

public class LoadInfo {
	// 自定义类加载
	private MyClassLoader myLoader;
	// 记录要加载类的时间戳，加载的时间
	private long loadTime;
	private BaseManager manager;

	public LoadInfo(MyClassLoader myLoader, long loadTime) {
		super();
		this.myLoader = myLoader;
		this.loadTime = loadTime;
	}

	public BaseManager getManager() {
		return manager;
	}

	public void setManager(BaseManager manager) {
		this.manager = manager;
	}

	public MyClassLoader getMyLoader() {
		return myLoader;
	}

	public long getLoadTime() {
		return loadTime;
	}

	public void setMyLoader(MyClassLoader myLoader) {
		this.myLoader = myLoader;
	}

	public void setLoadTime(long loadTime) {
		this.loadTime = loadTime;
	}

}
