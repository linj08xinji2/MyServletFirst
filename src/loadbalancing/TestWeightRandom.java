package loadbalancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * * 加權隨機载均衡算法
 * 
 * @author guoy
 *
 */
public class TestWeightRandom {
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

	public static String weightRandom() { // 重新建立一個map,避免出現由於服務器上線和下線導致的並發問題
		Map<String, Integer> serverMap = new HashMap<String, Integer>();
		serverMap.putAll(serverWeigthMap); // 獲取ip列表list
		Set<String> keySet = serverMap.keySet();
		Iterator<String> it = keySet.iterator();

		List<String> serverList = new ArrayList<String>();
		while (it.hasNext()) {
			String server = it.next();
			Integer weight = serverMap.get(server);
			for (int i = 0; i < weight; i++) {
				serverList.add(server);
			}
		}
		Random random = new Random();
		int randomPos = random.nextInt(serverList.size());
		String server = serverList.get(randomPos);
		return server;
	}

	public static void main(String[] args) {
		String serverIp = weightRandom();
		System.out.println(serverIp);
	}
}