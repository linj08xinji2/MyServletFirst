package com.text;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg_webchinese {

	public static void main(String[] args) throws Exception {

		HttpClient client = new HttpClient();
		// http://gbk.sms.webchinese.cn  http://sms.webchinese.cn/web_api/
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
		post.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=gbk");// ��ͷ�ļ�������ת��
		NameValuePair[] data = { new NameValuePair("Uid", "linj"), // ע����û���
				new NameValuePair("Key", "ac2ccb58a515a5a4c4e5"), // ע��ɹ���,��¼��վʹ�õ���Կ
				new NameValuePair("smsMob", "18818409610"), // �ֻ�����
				new NameValuePair("smsText", "��֤�룺8888") };// ���ö�������

		post.setRequestBody(data);

		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes(
				"gbk"));
		System.out.println(result);
		post.releaseConnection();
	}
}
