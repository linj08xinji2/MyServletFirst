package com.net;
import java.util.Date;

import javax.xml.namespace.QName;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
public class JavaCallNet {

	public static void main(String[] args) throws Exception {
		String endpoint = "http://192.168.65.134:99/PMSWebService/NCPMSService.asmx";
		// ����һ������(service)����(call)
		Service service = new Service();
		Call call = (Call) service.createCall();// ͨ��service����call����
		// ����service����URL
		call.setTargetEndpointAddress(new java.net.URL(endpoint));

		call.setOperationName(new QName("http://tempuri.org/", "getERP_Project"));
		// Add ��net �Ǳߵķ��� "http://tempuri.org/" ���ҲҪע��Namespace �ĵ�ַ,����Ҳ�ᱨ��
		call.addParameter(new QName("http://tempuri.org/", "pk_corpList"),
				org.apache.axis.encoding.XMLType.XSD_STRING,
				javax.xml.rpc.ParameterMode.IN);
		call.addParameter(new QName("http://tempuri.org/", "service_validation"),
				org.apache.axis.encoding.XMLType.XSD_STRING,
				javax.xml.rpc.ParameterMode.IN);
		// ������Ҹ���һ���ԭ������,"test" ������Ǵ������ı���,Ҳ����NET����Ĳ���,һ����Ҫ������
		// �ҵ�����֪�� ,��Ϊ����������Լ����д��,������Ǳ�NULL,������������

		call.setUseSOAPAction(true);
		call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING); // ���ز���������
		call.setSOAPActionURI("http://tempuri.org/getERP_Project"); // ���ҲҪע��
															// ����Ҫ����Ҫ���õķ���Add,��ȻҲ�ᱨ��

		// Object �����װ�˲���������Ϊ"This is Test!",����processService(String arg)
		Date d=new Date();
		System.out.println("����:"+d);
		String ret = (String) call.invoke(new Object[] { "AAA",MD5.getMD5Code("Mysoft_NC_Evergrande_20170217") });
		ret=ret.replace("{\"IsError\": true,\"ErrorInfo\": \"\",\"DataRows\": ", "");
		ret= ret.substring(0, ret.length()-1);
		//ret="\"aaa\"";
		System.out.println("--------" + ret);
		JSONArray jsonArray = JSONArray.fromObject(ret);
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			ManagementsecVO vo = (ManagementsecVO) net.sf.json.JSONObject.toBean(jsonObject,ManagementsecVO.class);
		   System.out.println(vo);
		}
	}

}
