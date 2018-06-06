/**
 * 
 */
package com.evergrande.open.business.repair;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicHeader;
//import org.apache.http.protocol.HTTP;
//import org.apache.http.util.EntityUtils;
//import java.time.Instant;

/**
 * @author FALSE KING create
 * @date 2017年7月11日 下午5:51:39
 */
public class MyHttpUtil {

	public static String encodeWithoutSalt(String str) {

		String encodeStr = null;
		try {
			// 声明消息摘要对象
			MessageDigest md = null;
			// 创建消息摘要
			md = MessageDigest.getInstance("MD5");
			// 将口令的数据传给消息摘要对象
			md.update(str.getBytes("UTF-8"));
			// 获得消息摘要的字节数组
			byte[] digest = md.digest();

			// 将字节数组格式加密后的口令转化为16进制字符串格式的口令
			encodeStr = byteToHexString(digest);
		} catch (NoSuchAlgorithmException e) {
			// logger.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			// logger.error(e.getMessage(), e);
		}

		return encodeStr;

	}

	/**
	 * 将指定byte数组转换成16进制字符串
	 * 
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte[] b) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			hexString.append(hex.toUpperCase());
		}
		return hexString.toString();
	}

	/*public static String postAsJson(String url,String	callcontext) {
		// HttpClient
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result = null;
		try {
			HttpPost httpPost = new HttpPost(url);
			StringEntity se = new StringEntity(callcontext, "UTF-8");
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			httpPost.setEntity(se);

			System.out.println("executing request " + httpPost.getURI());
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					System.out.println("--------------------------------------");
					result = EntityUtils.toString(entity, "UTF-8");
					System.out.println("Response content: " + result);
					System.out.println("--------------------------------------");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}*/

	public static String postAsJson2(String url, String callcontext) {
//		trustAllHosts();
		JSONObject joArray=JSONObject.fromObject(callcontext);
		String sign=joArray.getString("sign");
		String result = null;
		try {
			byte[] 	requestBytes = callcontext.getBytes("utf-8");
		 // 将参数转为二进制流
		HttpClient httpClient = new HttpClient();// 客户端实例化
		PostMethod postMethod = new PostMethod(url);
		// 设置请求头Authorization
//		postMethod.setRequestHeader("Authorization", sign);
		// 设置请求头 Content-Type
		postMethod.setRequestHeader("Content-Type", "application/json");
		InputStream inputStream = new ByteArrayInputStream(requestBytes, 0,
				requestBytes.length);
		RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
				requestBytes.length, "application/json; charset=utf-8"); // 请求体
		postMethod.setRequestEntity(requestEntity);
		httpClient.executeMethod(postMethod);// 执行请求
		InputStream soapResponseStream = postMethod.getResponseBodyAsStream();// 获取返回的流
		byte[] datas = null;
		try {
			datas = readInputStream(soapResponseStream);// 从输入流中读取数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		 result = new String(datas, "UTF-8");// 将二进制流转为String
		// 打印返回结果
//		System.out.println(result);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return result;
	}
	/**
     * 从输入流中读取数据
     * 
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();
        return data;
    }
    
    /**
     * Trust every server - dont check for any certificate
     */
	public static void trustAllHosts() {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return new java.security.cert.X509Certificate[] {};
			}
			public void checkClientTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}
			public void checkServerTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
			}
		} };

		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
