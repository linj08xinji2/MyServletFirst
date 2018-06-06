package com.my.thread;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

//���ܸĶ���Test��	
public class Testthree extends Thread{
	
	
	/**
	 * ���г���ͬʱ������4���߳�ȥ����TestDo.doSome(key, value)������
      ����TestDo.doSome(key, value)�����ڵĴ���������ͣ1�룬Ȼ�����������Ϊ��λ�ĵ�ǰʱ��ֵ��
      ���ԣ����ӡ��4����ͬ��ʱ��ֵ��������ʾ��
		4:4:1258199615
		1:1:1258199615
		3:3:1258199615
		1:2:1258199615
        ���޸Ĵ��룬����м����̵߳���TestDo.doSome(key, value)����ʱ�����ݽ�ȥ��key��ȣ�equals�Ƚ�Ϊtrue����
        ���⼸���߳�Ӧ�����Ŷ��������������������̵߳�key����"1"ʱ�������е�һ��Ҫ�����������߳���1����������
        ������ʾ��
		4:4:1258199615
		1:1:1258199615
		3:3:1258199615
		1:2:1258199616
	  ��֮����ÿ���߳���ָ����key���ʱ����Щ���key���߳�Ӧÿ��һ���������ʱ��ֵ��Ҫ�û��⣩��
	  ���key��ͬ������ִ�У��໥֮�䲻���⣩��

	 */
	private TestDos testDo;
	private String key;
	private String value;
	
	public Testthree(String key,String key2,String value){
		this.testDo = TestDos.getInstance();
		/*����"1"��"1"��ͬһ�������������д������Ҫ��"1"+""�ķ�ʽ�����µĶ���
		��ʵ������û�иı䣬��Ȼ��ȣ�����Ϊ"1"����������ȴ������ͬһ����Ч��*/
		this.key = key+key2; 
		this.value = value;
	}


	public static void main(String[] args) throws InterruptedException{
		Testthree a = new Testthree("1","","1");
		Testthree b = new Testthree("1","","2");
		Testthree c = new Testthree("3","","3");
		Testthree d = new Testthree("4","","4");
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		a.start();
		b.start();
		c.start();
		d.start();

	}
	
	public void run(){
		testDo.doSome(key, value);
	}
}

class TestDos {

	private TestDos() {}
	private static TestDos _instance = new TestDos();	
	public static TestDos getInstance() {
		return _instance;
	}

//	private ArrayList keys = new ArrayList();
	
	private CopyOnWriteArrayList<Object> keys = new CopyOnWriteArrayList<Object>();
	public void doSome(Object key, String value) {
		Object o = key;
		if(!keys.contains(o)){
			keys.add(o);
		}else{

			for(Iterator<Object> iter=keys.iterator();iter.hasNext();){
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Object oo = iter.next();
				if(oo.equals(o)){
					o = oo;
					break;
				}
			}
		}
		synchronized(o)
		
		
		
		// �Դ������ڵ�����Ҫ�ֲ�ͬ���Ĵ��룬���ܸĶ�!
		{
			try {
				Thread.sleep(1000);
				System.out.println(key+":"+value + ":"
						+ (System.currentTimeMillis() / 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}