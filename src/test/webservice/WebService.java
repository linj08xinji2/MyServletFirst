package test.webservice;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;




import com.net.MD5;



//import com.ufida.iufo.pub.tools.MD5;
import nc.vo.jcom.security.Base64;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

public class WebService {
	
	public static void main(String[] args) throws Exception {
//		new WebService().callJavaWebService();
//		new WebService().callJavaWebNoParService();
//		new WebService().call();
		new WebService().myoperstate();
	}

	private Object callJavaWebService() throws Exception {
		
		String url = "http://localhost:8080/Service/ServiceHello";
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(url));

		call.setOperationName(new QName("getValue"));
		//�������ã��������Ʊ�����wsdl�ļ��еĲ�������һ��
		call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN); 
//		call.addParameter("string1", XMLType.XSD_STRING, ParameterMode.IN);
//		call.addParameter("string2", XMLType.XSD_STRING, ParameterMode.IN);
//		call.addParameter("string3", XMLType.XSD_STRING, ParameterMode.IN);
//		call.addParameter("string4", XMLType.XSD_STRING, ParameterMode.IN);
		call.setReturnType(XMLType.XSD_STRING);// �����ķ���ֵ����
		String rs = (String) call.invoke(new Object[] { "101"});
//		String rs = (String) call.invoke(new Object[] { "1003ZZ1000000001TBV9", "9241", "Y", "", ""});
		System.out.println(rs);
		return rs;
	}
	
	// �޲�
	private Object callJavaWebNoParService() throws Exception {
		String url = "http://localhost/uapws/service/nc.itf.crmbd.pub.Test";
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(url));

		call.setOperationName(new QName("testnojson"));
		call.setReturnType(XMLType.XSD_STRING);// �����ķ���ֵ����
		String rs = (String) call.invoke(new Object[]{});;
		System.out.println("�޲Σ�"+rs);
		return rs;
	}
	
	private String call() throws Exception{
		String url = "http://localhost:8080/Service/ServiceHello";
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(url));
		// �ӿڷ���
		call.setOperationName(new QName("http://tempuri.org/", "getValue"));
		// �������ã��������Ʊ�����wsdl�ļ��еĲ�������һ��
			call.addParameter(new QName("http://tempuri.org/", "name"),
					XMLType.XSD_STRING, ParameterMode.IN);
		call.setReturnType(XMLType.XSD_STRING);// �����ķ���ֵ����
		call.setUseSOAPAction(true);
		call.setSOAPActionURI("http://tempuri.org/getValue");
		String rs = null;
		try {
				rs = (String) call.invoke(new Object[] { "abc"});
				// ҵ̬�ӿڣ�ֻ��һ������
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("result:" + rs);
		return rs;
	}
	
	/**
	 * 
	 */
	public void myoperstate() throws Exception {
		// ������  getERP_RoomToCustomerDetail  
		String menthod = "getERP_RoomToCustomerDetail"; // getERP_Project  getERP_ProductType  getERP_Building
		// ������
		List<String> parameters = new ArrayList<String>();  
		parameters.add("pk_mybuilding");
//		parameters.add("pk_myprojectidList");
		parameters.add("service_validation");
		String rs = callMy("E57CD3E8-6611-4E09-8211-EE7850293897", menthod, parameters);
//			String rs = callMy(null, menthod, parameters);
	}
	
	private String callMy(String want, String menthod,
			List<String> parameters) throws Exception {
		Service service = new Service();           // http://192.168.88.190:9000/Service.asmx
		Call call = (Call) service.createCall(); // http://192.168.65.134:8002/service.asmx
		call.setTargetEndpointAddress(new URL("http://192.168.88.190:9000/Service.asmx"));
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
		// // Mysoft_NC_Evergrande_20170721
		String keypassword="OGM0Nzc5MTAyY2FmYjhkYWI4NTRlNmFhZDI3MDBhZjA=";
		try {
			// ����32λСд
						if (null != want && !"".equals(want)) {
							rs = (String) call.invoke(new Object[] { want,keypassword});
							// ҵ̬�ӿڣ�ֻ��һ������
						} else {
							rs = (String) call.invoke(new Object[] {keypassword});
						}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("result:" + rs);
		/*JSONArray jsonArray = JSONArray.fromObject(JSONObject.fromObject(rs).getString("DataRows"));
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject j=JSONObject.fromObject(jsonArray.get(i));
			if(j.getString("fsexList").length()>5){
				System.out.println(j.getString("fsexList"));
			}
		}*/
		return rs;
	}
	
}
