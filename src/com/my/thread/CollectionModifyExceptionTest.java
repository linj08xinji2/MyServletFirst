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
 *  CopyOnWriteArrayList��ArrayList ��һ���̰߳�ȫ�ı��壬
 *  �������пɱ������add��set�ȵȣ�����ͨ���Եײ��������һ���µĸ�����ʵ�ֵġ�
 *  
 *  
 *  CopyOnWriteArrayList add(E) ��remove(int index)���Ƕ��µ���������޸ĺ�������
 *  �����ڶ��̲߳���ʱ�������java.util.ConcurrentModificationException����
 */

public class CollectionModifyExceptionTest {
	
	private static Log logger = LogFactory.getLog(CollectionModifyExceptionTest.class);
	
	public static void main(String[] args) {
		try {
		Collection<User> users = new ArrayList<User>();
			//new ArrayList();
		users.add(new User("����",28));	
		users.add(new User("����",25));			
		users.add(new User("����",31));	
		Iterator<User> itrUsers = users.iterator();
		while(itrUsers.hasNext()){
			System.out.println("aaaa");
			User user = (User)itrUsers.next();
			if("����".equals(user.getName())){
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
