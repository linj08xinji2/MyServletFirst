package test.webservice;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
//import com.ufida.iufo.pub.tools.MD5;

public class AfterBefore {

	public static void main(String[] args) {
		after();
//		before();
	}

	private static void before() {
		try {
			String endpoint = "https://ht-open-api-dev.evergrande.com";
			String namespace = "http://tempuri.org/";
			String method="updateRepairOrderStatus";
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new URL(endpoint));
			call.setOperationName(new QName(namespace, method));
			call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.XSD_STRING);
			call.setUseSOAPAction(true);
			call.setSOAPActionURI(namespace + method);
			// string
			String result = "{\"timestamp\":1499829531,\"sign\":\"8ED9B077EF79005BB1FF3EE48BA3F523\",\"request\":{\"parameter\":[{\"repairResult\":\"2\",\"orderSn\":\"87654323456789\",\"commend\":\"�رչ���������Ҫά��\",\"handleTime\":\"1499512136288\",\"handler\":\"okk\"},{\"repairResult\":\"1\",\"orderSn\":\"AAAA\",\"commend\":\"�رչ���������Ҫά��\",\"handleTime\":\"1499512136288\",\"handler\":\"abccc\"},{\"repairResult\":2,\"orderSn\":\"2140340656084992\",\"commend\":\"��ɹ���\",\"handleTime\":1499512136288,\"handler\":\"��ҵά��2\"}],\"commandname\":\"updateRepairOrderStatus\"},\"appid\":\"ht2261224539986944\"}";
			
			String	rs = (String) call.invoke(new Object[] {result});	
			System.out.println("result:" + rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void after() {
		String menthod = "updateRepairOrderStatus";
		// ������
		String parameter = "parameter";
		String rs = null;
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new URL("https://ht-open-api-dev.evergrande.com"));
			// �ӿڷ���
			call.setOperationName(new QName("http://tempuri.org/", menthod));
			// �������ã��������Ʊ�����wsdl�ļ��еĲ�������һ��
			call.addParameter(new QName("http://tempuri.org/", parameter),
					XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.XSD_STRING);// �����ķ���ֵ����
			call.setUseSOAPAction(true);
			call.setSOAPActionURI("http://tempuri.org/" + menthod + "");
			String result = "{\"timestamp\":1499829531,\"sign\":\"8ED9B077EF79005BB1FF3EE48BA3F523\",\"request\":{\"parameter\":[{\"repairResult\":\"2\",\"orderSn\":\"87654323456789\",\"commend\":\"�رչ���������Ҫά��\",\"handleTime\":\"1499512136288\",\"handler\":\"okk\"},{\"repairResult\":\"1\",\"orderSn\":\"AAAA\",\"commend\":\"�رչ���������Ҫά��\",\"handleTime\":\"1499512136288\",\"handler\":\"abccc\"},{\"repairResult\":2,\"orderSn\":\"2140340656084992\",\"commend\":\"��ɹ���\",\"handleTime\":1499512136288,\"handler\":\"��ҵά��2\"}],\"commandname\":\"updateRepairOrderStatus\"},\"appid\":\"ht2261224539986944\"}";
			rs = (String) call.invoke(new Object[] { result });
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("result:" + rs);
	}
}