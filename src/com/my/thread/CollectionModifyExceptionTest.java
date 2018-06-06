package com.my.thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import logging.LoggerTest;

/**
 *  CopyOnWriteArrayList是ArrayList 的一个线程安全的变体，
 *  其中所有可变操作（add、set等等）都是通过对底层数组进行一次新的复制来实现的。
 *  
 *  
 *  CopyOnWriteArrayList add(E) 和remove(int index)都是对新的数组进行修改和新增。
 *  所以在多线程操作时不会出现java.util.ConcurrentModificationException错误
 */

public class CollectionModifyExceptionTest {
	
	private static Log logger = LogFactory.getLog(CollectionModifyExceptionTest.class);
	
	public static void main(String[] args) {
		try {
		Collection<User> users = new ArrayList<User>();
			//new ArrayList();
		users.add(new User("张三",28));	
		users.add(new User("李四",25));			
		users.add(new User("王五",31));	
		Iterator<User> itrUsers = users.iterator();
		while(itrUsers.hasNext()){
			System.out.println("aaaa");
			User user = (User)itrUsers.next();
			if("王五".equals(user.getName())){
				users.remove(user);
				//itrUsers.remove();
			} else {
				System.out.println(user);				
			}
		}
		} catch (Exception e) {
			logger.debug(e);
			logger.error(e);
			logger.info(e);
			logger.warn(e);
			logger.fatal(e);
			logger.trace(e);
			e.printStackTrace();
		}
	}
}	 
