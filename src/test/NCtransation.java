package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class NCtransation {
	private static List<String> movingflooridList = new ArrayList<String>();

	private static StringBuffer errorMsg = new StringBuffer();

	private static List<Object> name_id_list = new ArrayList<Object>(); // ������Ϣ
																		// ���鳤��Ϊ2����һ��Ϊ���ķ������ƣ��ڶ���Ϊ����ID

	public static void main(String[] args) {
	String a=ResultMsg.getMessage2("0", errorMsg.toString(), movingflooridList,
				name_id_list, 0);

		System.out.println(a);
	}
}

class ResultMsg {
	public static String getMessage2(String stateValue, String errmsgValue,
			List<String> movingflooridList, List<Object> name_id_list,
			int successNum) {
		// Json
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", stateValue); // ״̬ 0���ɹ� 1��ʧ��
		map.put("errmsg", errmsgValue); // ������Ϣ
		map.put("listSuccessProblemId", movingflooridList); // �ɹ�������id
		map.put("listFaildProblemDetail", name_id_list); // ������Ϣ
															// ���鳤��Ϊ2����һ��Ϊ���ķ������ƣ��ڶ���Ϊ����ID
		map.put("successNumber", successNum);
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
}
