package ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPtest {

	public static void main(String[] args) {
		try { // ��ȡ�������
			String name = InetAddress.getLocalHost().getHostName();
			// ��ȡIP��ַ
			String ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println("���������" + name);
			System.out.println("IP��ַ��" + ip);
		} catch (UnknownHostException e) {
			System.out.println("�쳣��" + e);
			e.printStackTrace();
		}
	}
	}


