package datetime;

import java.util.Date;

public class LongDateTest {

	public static void main(String[] args) {
		java.util.Date dt = new Date();
		System.out.println(dt.toString());   //java.util.Date�ĺ���
		long lSysTime1 = dt.getTime() / 1000;   //�õ�������Date���͵�getTime()���غ�����
		System.out.println(lSysTime1);
	}

}
