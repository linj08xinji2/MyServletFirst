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
			String result = "{\"timestamp\":1499829531,\"sign\":\"8ED9B077EF79005BB1FF3EE48BA3F523\",\"request\":{\"parameter\":[{\"repairResult\":\"2\",\"orderSn\":\"87654323456789\",\"commend\":\"关闭工单，不需要维修\",\"handleTime\":\"1499512136288\",\"handler\":\"okk\"},{\"repairResult\":\"1\",\"orderSn\":\"AAAA\",\"commend\":\"关闭工单，不需要维修\",\"handleTime\":\"1499512136288\",\"handler\":\"abccc\"},{\"repairResult\":2,\"orderSn\":\"2140340656084992\",\"commend\":\"完成工单\",\"handleTime\":1499512136288,\"handler\":\"物业维修2\"}],\"commandname\":\"updateRepairOrderStatus\"},\"appid\":\"ht2261224539986944\"}";
			
			String	rs = (String) call.invoke(new Object[] {result});	
			System.out.println("result:" + rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void after() {
		String menthod = "updateRepairOrderStatus";
		// 传参数
		String parameter = "parameter";
		String rs = null;
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new URL("https://ht-open-api-dev.evergrande.com"));
			// 接口方法
			call.setOperationName(new QName("http://tempuri.org/", menthod));
			// 参数设置，参数名称必须与wsdl文件中的参数名称一致
			call.addParameter(new QName("http://tempuri.org/", parameter),
					XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.XSD_STRING);// 方法的返回值类型
			call.setUseSOAPAction(true);
			call.setSOAPActionURI("http://tempuri.org/" + menthod + "");
			String result = "{\"timestamp\":1499829531,\"sign\":\"8ED9B077EF79005BB1FF3EE48BA3F523\",\"request\":{\"parameter\":[{\"repairResult\":\"2\",\"orderSn\":\"87654323456789\",\"commend\":\"关闭工单，不需要维修\",\"handleTime\":\"1499512136288\",\"handler\":\"okk\"},{\"repairResult\":\"1\",\"orderSn\":\"AAAA\",\"commend\":\"关闭工单，不需要维修\",\"handleTime\":\"1499512136288\",\"handler\":\"abccc\"},{\"repairResult\":2,\"orderSn\":\"2140340656084992\",\"commend\":\"完成工单\",\"handleTime\":1499512136288,\"handler\":\"物业维修2\"}],\"commandname\":\"updateRepairOrderStatus\"},\"appid\":\"ht2261224539986944\"}";
			rs = (String) call.invoke(new Object[] { result });
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("result:" + rs);
	}
}