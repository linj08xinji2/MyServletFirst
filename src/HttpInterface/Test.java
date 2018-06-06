package HttpInterface;

import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		long timestamp=System.currentTimeMillis()/1000;
		String result = "{\"timestamp\":"+timestamp+",\"sign\":\"8ED9B077EF79005BB1FF3EE48BA3F523\",\"request\":{\"parameter\":[{\"repairResult\":\"2\",\"orderSn\":\"87654323456789\",\"commend\":\"关闭工单，不需要维修\",\"handleTime\":\"1499512136288\",\"handler\":\"okk\"},{\"repairResult\":\"1\",\"orderSn\":\"AAAA\",\"commend\":\"关闭工单，不需要维修\",\"handleTime\":\"1499512136288\",\"handler\":\"abccc\"},{\"repairResult\":2,\"orderSn\":\"2140340656084992\",\"commend\":\"完成工单\",\"handleTime\":1499512136288,\"handler\":\"物业维修2\"}],\"commandname\":\"updateRepairOrderStatus\"},\"appid\":\"ht2261224539986944\"}";
		
		String url = "https://ht-open-api-dev.evergrande.com" + "/openservice/api";
		try {
			HttpTool.sendPost(result, url);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
