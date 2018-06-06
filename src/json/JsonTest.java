package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.evergrande.open.business.repair.MyHttpUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {

	public static void main(String[] args) {
//		json1();
//		json2();
		json3();
	}

	private static void json1() {
		List<Map<String, String>> list=new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("htproblemid", "RS_201605260000011_04470232");  
		map.put("iscomplete", "Y");  
		map.put("ireportstatus", "3");
		map.put("closeinfo", "关闭原因");
		map.put("completetime", "完成时间");   // vdef10
		map.put("closetime", "关闭时间");   //vdef9
		list.add(map);
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("htproblemid", "RS_201605180000006_96407057");  
		map2.put("iscomplete", "N");  
		map2.put("ireportstatus", "1");
		map2.put("closeinfo", "AABBBBBBBB");
		map2.put("completetime", "2017年6月28日11时7分");  
		map2.put("closetime", "二○一七年六月二十八日t");  
		list.add(map2);
		JSONArray json= JSONArray.fromObject(list);
		System.out.println(json);
	}

	private static void json2() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, Object> mapchild = new HashMap<String, Object>();
		mapchild.put("commandname", "updateRepairOrderStatus");  
		
		
		map.put("request", mapchild);  
		
		List<Map<String, String>> list=new ArrayList<Map<String, String>>();
		Map<String, String> mapresult = new HashMap<String, String>();
		mapresult.put("orderSn", "87654323456789");  
		mapresult.put("repairResult", "2");
		mapresult.put("handler", "okk");
		mapresult.put("handleTime", "1499512136288");
		mapresult.put("commend", "关闭工单，不需要维修");
		list.add(mapresult);
		mapresult = new HashMap<String, String>();
		mapresult.put("orderSn", "AAAA");  
		mapresult.put("repairResult", "1");
		mapresult.put("handler", "abccc");
		mapresult.put("handleTime", "1499512136288");
		mapresult.put("commend", "关闭工单，不需要维修");
		list.add(mapresult);
		
		mapchild.put("parameter", list);
		
		map.put("sign", "7FFB635D5E58D9D995840AF37FF2AE7A");  
		map.put("appid", "DEMO");
		map.put("timestamp", "1458555139");
		JSONObject a=JSONObject.fromObject(map);
		System.out.println(a);
		System.out.println(JSONObject.fromObject(mapchild).toString());
	}
	
	
	private static void json3() {
		String result = "{\"timestamp\":1499829531,\"sign\":\"8ED9B077EF79005BB1FF3EE48BA3F523\",\"request\":{\"parameter\":[{\"repairResult\":\"2\",\"orderSn\":\"87654323456789\",\"commend\":\"关闭工单，不需要维修\",\"handleTime\":\"1499512136288\",\"handler\":\"okk\"},{\"repairResult\":\"1\",\"orderSn\":\"AAAA\",\"commend\":\"关闭工单，不需要维修\",\"handleTime\":\"1499512136288\",\"handler\":\"abccc\"},{\"repairResult\":2,\"orderSn\":\"2140340656084992\",\"commend\":\"完成工单\",\"handleTime\":1499512136288,\"handler\":\"物业维修2\"}],\"commandname\":\"updateRepairOrderStatus\"},\"appid\":\"ht2261224539986944\"}";
		JSONObject object = JSONObject.fromObject(result);
		System.out.println("sign:" + object.getString("sign"));
		JSONObject request = object.getJSONObject("request");
		System.out.println("request :" + request);
		JSONArray jsonArray = JSONArray.fromObject(request.getString("parameter"));
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			System.out.println("orderSn: " + jsonObject.getString("orderSn"));
			System.out.println("repairResult: " + jsonObject.getString("repairResult"));
			System.out.println("handleTime: " + jsonObject.getString("handleTime"));
		}
	}
}
