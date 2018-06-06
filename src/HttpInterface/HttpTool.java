package HttpInterface;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

public class HttpTool {

    /**
     * ����post����
     * 
     * @author Michael -----CSDN: http://blog.csdn.net/capmiachael
     * @param params
     *            ����
     * @param requestUrl
     *            �����ַ
     * @param authorization
     *            ��Ȩ��
     * @return ���ؽ��
     * @throws IOException
     */
	 public static String sendPost(String params, String requestUrl) throws IOException {
//    public static String sendPost(String params, String requestUrl,
//            String authorization) throws IOException {

        byte[] requestBytes = params.getBytes("utf-8"); // ������תΪ��������
        HttpClient httpClient = new HttpClient();// �ͻ���ʵ����
        PostMethod postMethod = new PostMethod(requestUrl);
        //��������ͷAuthorization
//        postMethod.setRequestHeader("Authorization", "Basic " + authorization);
        // ��������ͷ  Content-Type
        postMethod.setRequestHeader("Content-Type", "application/json");
        InputStream inputStream = new ByteArrayInputStream(requestBytes, 0,
                requestBytes.length);
        RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
                requestBytes.length, "application/json; charset=utf-8"); // ������
        postMethod.setRequestEntity(requestEntity);
        httpClient.executeMethod(postMethod);// ִ������
        InputStream soapResponseStream = postMethod.getResponseBodyAsStream();// ��ȡ���ص���
        byte[] datas = null;
        try {
            datas = readInputStream(soapResponseStream);// ���������ж�ȡ����
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = new String(datas, "UTF-8");// ����������תΪString
        // ��ӡ���ؽ��
         System.out.println(result);

        return result;

    }

    /**
     * ���������ж�ȡ����
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
}