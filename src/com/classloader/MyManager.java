package com.classloader;

/**
 * 此类实现java类热加载功能
 *
 */
public class MyManager implements BaseManager {

	@Override
	public void logic() {
		System.out.println("11111");
		getMessage();
		getMessage2();
	}

	private void getMessage() {
		System.out.println("12");
	}

	public void getMessage2() {
		System.out.println("CCCCCCC");
	}
}
