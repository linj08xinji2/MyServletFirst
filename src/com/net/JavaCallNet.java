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
		// 创建一个服务(service)调用(call)
		Service service = new Service();
		Call call = (Call) service.createCall();// 通过service创建call对象
		// 设置service所在URL
		call.setTargetEndpointAddress(new java.net.URL(endpoint));

		call.setOperationName(new QName("http://tempuri.org/", "getERP_Project"));
		// Add 是net 那边的方法 "http://tempuri.org/" 这个也要注意Namespace 的地址,不带也会报错
		call.addParameter(new QName("http://tempuri.org/", "pk_corpList"),
				org.apache.axis.encoding.XMLType.XSD_STRING,
				javax.xml.rpc.ParameterMode.IN);
		call.addParameter(new QName("http://tempuri.org/", "service_validation"),
				org.apache.axis.encoding.XMLType.XSD_STRING,
				javax.xml.rpc.ParameterMode.IN);
		// 这就是我搞了一天的原因所在,"test" 这个就是传参数的变量,也就是NET方面的参数,一定不要带错了
		// 我当初不知道 ,以为这个参数是自己随便写的,结果总是报NULL,真是气死人了

		call.setUseSOAPAction(true);
		call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING); // 返回参数的类型
		call.setSOAPActionURI("http://tempuri.org/getERP_Project"); // 这个也要注意
															// 就是要加上要调用的方法Add,不然也会报错

		// Object 数组封装了参数，参数为"This is Test!",调用processService(String arg)
		Date d=new Date();
		System.out.println("日期:"+d);
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
