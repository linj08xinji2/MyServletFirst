package test.webservice;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;


public class AddBillThreadTest {

	public static void main(String[] args) {
		final Outputer out = new Outputer();
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					out.output();
				}
			}).start();
		}
	}
	static class Outputer {
		private  void output() {
			try {
				String endpoint = "http://127.0.0.1/uapws/service/nc.itf.ws.ws2210.IAddBill";
				String namespace = "http://tempuri.org/";
				String method="addNewBill";
				Service service = new Service();
				Call call = (Call) service.createCall();
				call.setTargetEndpointAddress(new URL(endpoint));
				call.setOperationName(new QName(namespace, method));
				call.addParameter("string", XMLType.XSD_STRING, ParameterMode.IN);
				call.setReturnType(XMLType.XSD_STRING);
				call.setUseSOAPAction(true);
				call.setSOAPActionURI(namespace + method);
				// string
				StringBuilder sb=new StringBuilder();
				sb.append(" [{\"project\": \"project1\",  \"building\": \"ban1\",  ");
				sb.append("         \"vhcell\": \"unit1\", \"houseid\": \"00311C0B-36F8-496C-A465-04CB515475B0\",  \"reportpsnid\": \"admin1\",  ");
				sb.append("         \"recordingtime\": \"2016-08-09 11:09:01\",  ");
				sb.append("          \"uploadtime\": \"2016-12-27 11:09:01\",\"createdate\":\"2016-12-27 14:09:01\", ");
				sb.append("          \"keystatus\":\"0\", \"cstname\":\"我的七大姨八大姑ss\", \"cstphone\":\"18818409610\", ");
				sb.append("         \"lists\": [ ");
				sb.append("             { \"movingfloorid\": \"问题id11\", \"vreportcontent\": \"主卧室漏水1\",\"remark\":\"现场整改通过\" ");
				sb.append("             }, {\"movingfloorid\": \"问题id21\", \"vreportcontent\": \"主卧室漏水2\", \"remark\":\"\" ");
				sb.append("             } ] }] ");
				String	rs = (String) call.invoke(new Object[] {sb.toString()});	
				System.out.println("result:" + rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
