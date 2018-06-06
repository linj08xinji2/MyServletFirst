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
				"application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
		NameValuePair[] data = { new NameValuePair("Uid", "linj"), // 注册的用户名
				new NameValuePair("Key", "ac2ccb58a515a5a4c4e5"), // 注册成功后,登录网站使用的密钥
				new NameValuePair("smsMob", "18818409610"), // 手机号码
				new NameValuePair("smsText", "验证码：8888") };// 设置短信内容

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
