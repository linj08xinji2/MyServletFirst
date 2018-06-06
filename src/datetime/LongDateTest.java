package datetime;

import java.util.Date;

public class LongDateTest {

	public static void main(String[] args) {
		java.util.Date dt = new Date();
		System.out.println(dt.toString());   //java.util.Date的含义
		long lSysTime1 = dt.getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
		System.out.println(lSysTime1);
	}

}
