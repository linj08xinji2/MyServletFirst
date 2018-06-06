package test.webservice;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;


public class CallTest {

	public static void main(String[] args) {
		try {
			new CallTest().callbuliding();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String callhELLo() throws Exception{
		String url = "http://192.168.65.134:8002/service.asmx";
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(url));
		// �ӿڷ���
		call.setOperationName(new QName("http://tempuri.org/", "HelloWorld"));
		// �������ã��������Ʊ�����wsdl�ļ��еĲ�������һ��
		/*	call.addParameter(new QName("http://tempuri.org/", "name"),
					XMLType.XSD_STRING, ParameterMode.IN);*/
		call.setReturnType(XMLType.XSD_STRING);// �����ķ���ֵ����
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("http://tempuri.org/HelloWorld");
		String rs = null;
		try {
				rs = (String) call.invoke(new Object[] {});
				// ҵ̬�ӿڣ�ֻ��һ������
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("result:" + rs);
		
		return rs;
	}
	
	private String callbuliding() throws Exception{
		String url = "http://192.168.65.134:8002/service.asmx";
		String menthod = "getERP_Building";
		List<String> parameters = new ArrayList<String>();
		parameters.add("pk_myprojectidList");
		parameters.add("service_validation");
		String rs = callMy("aabcc", url, menthod, parameters);
		return rs;
	}
	
	private String callMy(String want, String url, String menthod,
			List<String> parameters) throws Exception {
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(url));
		// �ӿڷ���
		call.setOperationName(new QName("http://tempuri.org/", menthod));
		// �������ã��������Ʊ�����wsdl�ļ��еĲ�������һ��
		for (String parameter : parameters) {
			call.addParameter(new QName("http://tempuri.org/", parameter),
					XMLType.XSD_STRING, ParameterMode.IN);
		}
		call.setReturnType(XMLType.XSD_STRING);// �����ķ���ֵ����
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("http://tempuri.org/" + menthod + "");
		String rs = null;
		try {
			if (null != want && !"".equals(want)) {
				rs = (String) call.invoke(new Object[] { "BE5E2655-2D25-4DDB-AF93-461C6988DC3B","a5b8f7e84e5a6c7d1a83b0086649e859" });
				// ҵ̬�ӿڣ�ֻ��һ������
			} else {
				Object object = (String) call.invoke(new Object[] { });
				System.out.println(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 System.out.println("result:" + rs);
//		 JSONObject jo=JSONObject.fromObject(rs);//��ʽ����json����
		 JSONArray jsonArray = JSONArray.fromObject(JSONObject.fromObject(rs).getString("DataRows"));
		 for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				System.out.println(jsonObject);
			}
		/* JSONArray array = new JSONObject(rs).getJSONArray("DataRows");  
			for (int i = 0; i < array.length(); i++) {
				JSONObject jsonObject = (JSONObject) array.get(i);
				System.out.println(jsonObject);
			}*/
		return rs;
	}
}
