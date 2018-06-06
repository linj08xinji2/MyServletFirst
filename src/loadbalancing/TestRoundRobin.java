package loadbalancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ؓ�d�����㷨��݆ԃ��
 * 
 * @author guoy
 *
 */
public class TestRoundRobin {
	static Map<String, Integer> serverWeigthMap = new HashMap<String, Integer>();

	static {
		serverWeigthMap.put("192.168.1.12", 1);
		serverWeigthMap.put("192.168.1.13", 1);
		serverWeigthMap.put("192.168.1.14", 2);
		serverWeigthMap.put("192.168.1.15", 2);
		serverWeigthMap.put("192.168.1.16", 3);
		serverWeigthMap.put("192.168.1.17", 3);
		serverWeigthMap.put("192.168.1.18", 1);
		serverWeigthMap.put("192.168.1.19", 2);
	}
	Integer pos = 0;

	public String roundRobin() {
		// ���½���һ��map,������F��춷������Ͼ����¾����µāK�l���}
		Map<String, Integer> serverMap = new HashMap<String, Integer>();
		serverMap.putAll(serverWeigthMap); // �@ȡip�б�list
		Set<String> keySet = serverMap.keySet();
		ArrayList<String> keyList = new ArrayList<String>();
		keyList.addAll(keySet);
		String server = null;

		synchronized (pos) {
			if (pos >= keySet.size()) {
				pos = 0;
			}
			server = keyList.get(pos);
			pos++;
		}
		return server;
	}

	public static void main(String[] args) {
		TestRoundRobin robin = new TestRoundRobin();
		for (int i = 0; i < 20; i++) {
			String serverIp = robin.roundRobin();
			System.out.println(serverIp);
		}
	}
}