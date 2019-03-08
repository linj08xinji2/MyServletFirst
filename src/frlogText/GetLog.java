package frlogText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class GetLog {

	
	public static void main(String[] args) {
		List<MessageVO> list=new ArrayList<MessageVO>();
		/* ��ȡ���� */
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(new File("C:\\Users\\longy_000\\Desktop\\fr��¼��¼20181226"))
					, "GBK"));
			String lineTxt = null;
			MessageVO vo=new MessageVO();
			while ((lineTxt = br.readLine()) != null) {
				if((isContainEnglisth(lineTxt)&&!lineTxt.contains("("))||
						(isContainChinese(lineTxt)&&!lineTxt.contains("("))){
					vo=new MessageVO();
					vo.setReportname(lineTxt);
					list.add(vo);
				}
				if(lineTxt.contains(".")){
					vo.setIp(lineTxt);
				}
				if(lineTxt.contains("(")&&lineTxt.contains(")")){
					vo.setUsername(lineTxt);
				}
				if(lineTxt.contains("-")&&lineTxt.contains(":")){
					vo.setStarttime(lineTxt);
				}
				
			}
			System.out.println(list.size());
			br.close();
		} catch (Exception e) {
			System.err.println("read errors :" + e);
		}
      
		/*for (MessageVO messageVO : list) {
			System.out.println(messageVO.toString());
		}*/
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+": "+list.get(i).toString());
		}
		
	}
	/**
     * �ж��ַ������Ƿ��������
     * @param str
     * ��У���ַ���
     * @return �Ƿ�Ϊ����
     * @warn ����У���Ƿ�Ϊ���ı�����
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
    
    
    public static boolean isContainEnglisth(String str) {
        Pattern p = Pattern.compile("[a-zA-z]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
