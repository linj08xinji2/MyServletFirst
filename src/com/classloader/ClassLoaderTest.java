package com.classloader;

public class ClassLoaderTest {

	// 测试    debug模式才生效？？
	public static void main(String[] args) {
		new Thread(new MsgHandler()).start();
	}

}
