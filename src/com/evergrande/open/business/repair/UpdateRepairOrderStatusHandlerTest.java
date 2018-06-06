/**
 * 
 */
package com.evergrande.open.business.repair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FALSE KING create
 * @date 2017年7月11日 下午5:50:54
 */
public class UpdateRepairOrderStatusHandlerTest {
	public static void main(String[] args) {
//		String reqUrl = "http://localhost:20504";
//		String reqUrl = "https://ht-open-api-test.htmimi.com/openservice/api";
		String reqUrl = "https://ht-open-api-dev.evergrande.com";
//      String reqUrl = "http://dev.open-api.hd/";
//		String reqUrl = "https://ht-open-api-test.evergrande.com";
		String appId = "ht2262543746064384";
		String appScrectKey = "is8WjYfHlsX80AhCBiYOW8pZirVcpXQ9R+XfD96c19k=";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderSn", "2140340656084992");
		map.put("repairResult", 2);
		map.put("handler", "物业维修2");
		map.put("handleTime", 1499512136288L);
		map.put("commend", "完成工单");

		String result = HttpUtil.postAsJson(reqUrl + "/openservice/api", "updateRepairOrderStatus", 
				appId, appScrectKey, map);
		System.out.println(result);
	}
	
	
	
}
