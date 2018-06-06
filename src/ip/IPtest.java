package ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPtest {

	public static void main(String[] args) {
		try { // 获取计算机名
			String name = InetAddress.getLocalHost().getHostName();
			// 获取IP地址
			String ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println("计算机名：" + name);
			System.out.println("IP地址：" + ip);
		} catch (UnknownHostException e) {
			System.out.println("异常：" + e);
			e.printStackTrace();
		}
	}
	}


