/**
 * 
 */
package com.evergrande.open.business.repair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * @author FALSE KING create
 * @date 2017年7月11日 下午5:50:54
 */
public class MyUpdateRepairOrderStatusHandlerTest {
	public static void main(String[] args) {
//		String reqUrl = "http://localhost:20504";
//		String reqUrl = "https://ht-open-api-test.htmimi.com/openservice/api";
		String reqUrl = "https://ht-open-api-dev.evergrande.com";
//      String reqUrl = "http://dev.open-api.hd/";
//		String reqUrl = "https://ht-open-api-test.evergrande.com";
		String appId = "ht2262543746064384";//  ht2262543746064384
		String appScrectKey = "is8WjYfHlsX80AhCBiYOW8pZirVcpXQ9R+XfD96c19k=";
		
		String result = MyHttpUtil.postAsJson2(reqUrl + "/openservice/api",
				getValues(appId,appScrectKey));
		System.out.println(result);
	}
	
	private static String getValues(String appId, String appScrectKey) {
		
       Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, Object> mapchild = new HashMap<String, Object>();
		mapchild.put("commandname", "updateRepairOrderStatus");  
		
		map.put("request", mapchild);  
		
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		Map<String, Object> mapresult = new HashMap<String, Object>();
		mapresult.put("orderSn", "87654323456789");  
		mapresult.put("repairResult", 2);
		mapresult.put("handler", "okk");
		mapresult.put("handleTime", "1499512136288");
		mapresult.put("commend", "关闭工单，不需要维修");
		list.add(mapresult);
		mapresult = new HashMap<String, Object>();
		mapresult.put("orderSn", "AAAA");  
		mapresult.put("repairResult", 1);
		mapresult.put("handler", "abccc");
		mapresult.put("handleTime", "1499512136288");
		mapresult.put("commend", "关闭工单，不需要维修");
		list.add(mapresult);
		mapresult=new HashMap<String, Object>();
		mapresult.put("orderSn", "2140340656084992");
		mapresult.put("repairResult", 2);
		mapresult.put("handler", "物业维修2");
		mapresult.put("handleTime", 1499512136288L);
		mapresult.put("commend", "完成工单");
		list.add(mapresult);
		
		mapchild.put("parameter", list);
		
		map.put("appid", appId);
		String requestContent = JSONObject.fromObject(mapchild).toString();
		System.out.println(requestContent);
		long realTimestamp=System.currentTimeMillis() / 1000;
		String signSource = appId + appScrectKey + realTimestamp + requestContent;
		map.put("timestamp", realTimestamp);
		String sign = MyHttpUtil.encodeWithoutSalt(signSource);
		System.out.println("=============sign:" + sign);
		map.put("sign", sign);  
		JSONObject a=JSONObject.fromObject(map);
		System.out.println(a);
		
		return a.toString();
	}
}
