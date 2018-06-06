/**
 * 
 */
package com.evergrande.open.business.repair;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.time.Instant;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/**
 * @author FALSE KING create
 * @date 2017年7月11日 下午5:51:39
 */
public class HttpUtil {

	private static String encodeWithoutSalt(String str) {

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

	public static String postAsJson(String url, String commandname, String appId, String appScrectKey,
			Map<String,Object> paramMap) {
		// HttpClient
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result = null;

		try {
//			Instant now = Instant.now();
//			System.out.println(now.toString());
//			System.out.println(now.toEpochMilli());
//			long realTimestamp = now.toEpochMilli() / 1000;
			long realTimestamp=System.currentTimeMillis() / 1000;
			System.out.println(realTimestamp);

			HttpPost httpPost = new HttpPost(url);
			JsonFactory f = new JsonFactory();
			StringWriter writer = new StringWriter();
			StringWriter writer2 = new StringWriter();
			JsonGenerator gen2 = f.createGenerator(writer2);
			JsonGenerator gen1 = f.createGenerator(writer);

			gen1.writeStartObject();
			gen2.writeStartObject();
			gen1.writeObjectFieldStart("request");

			gen1.writeStringField("commandname", commandname);// 访问Demobusiness测试接口连通性
			gen2.writeStringField("commandname", commandname);
			gen1.writeObjectFieldStart("parameter");
			gen2.writeObjectFieldStart("parameter");
			for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
				gen1.writeObjectField(entry.getKey(), entry.getValue());
				gen2.writeObjectField(entry.getKey(), entry.getValue());
			}
			gen1.writeEndObject();
			gen2.writeEndObject();
			gen2.close();
			gen1.writeEndObject();
			gen1.flush();
			// 对request的内容进行签名
			String requestContent = writer2.toString();
			System.out.println(requestContent);
			String signSource = appId + appScrectKey + realTimestamp + requestContent;
			String sign = encodeWithoutSalt(signSource);
			System.out.println("=============sign:" + sign);
			gen1.writeStringField("sign", sign);
			gen1.writeStringField("appid", appId);
			gen1.writeNumberField("timestamp", realTimestamp);
			gen1.writeEndObject();
			gen1.close();

			StringEntity se = new StringEntity(writer.toString(), "UTF-8");
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			httpPost.setEntity(se);

			System.out.println("executing request " + httpPost.getURI());
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					System.out.println("--------------------------------------");
					result = EntityUtils.toString(entity, "UTF-8");  // UTF-8
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
	}

}
