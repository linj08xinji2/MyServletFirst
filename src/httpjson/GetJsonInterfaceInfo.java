package httpjson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 接收服务端Json数据
 * 
 * 
 */
public class GetJsonInterfaceInfo {
//	private static String urlPath = "http://localhost:8080/MyServletFirst/servlet/JsonServlet";
	private static String urlPath = "http://localhost/servlet/~fdc_cs/httpjson.JsonServlet?linj=abcde&password=12334";
//	private static String urlPath = "http://192.168.66.5:8089/servlet/~fdc_cs/hz.bs.app.service.PostSignData?linj=123456eef&password=12334";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// ServerFactory.getServer(8080).start();
		// 列出原始数据
		StringBuilder json = new StringBuilder();

		URL oracle = new URL(GetJsonInterfaceInfo.urlPath);
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream(), "UTF-8"));
		String inputLine = null;
		while ((inputLine = in.readLine()) != null) {
			json.append(inputLine);
		}
		in.close();
		String Strjson = json.toString();
		System.out.println("原始数据:");
		System.out.println(Strjson.toString());
	}

}