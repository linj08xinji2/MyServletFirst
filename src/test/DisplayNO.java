package test;

public class DisplayNO {

	public static void main(String[] args) {
		System.out.println(getdisplayno("01","1"));;
	}

	
	private static String getdisplayno(String vhnumStr1, String infloor) {
		//edited by rengb ȥ���ո�
		String vhnumStr = vhnumStr1.trim();
		
		String houseTempVhdisplayno="";
		String floorOfHouseNum = null;
		try{
			Integer floor = Integer.parseInt(vhnumStr.substring(0,2));
			floorOfHouseNum = String.valueOf(floor);
		}catch(Exception e){
			floorOfHouseNum = String.valueOf(vhnumStr.substring(0,2));
		}
		//add by zhangws ���ڷ���ֻ��2λ�������������ʾ�������2A��---��002000A��
		if(vhnumStr.length()==2){
			houseTempVhdisplayno = "00"+vhnumStr.substring(0, 1)+"000"+vhnumStr.substring(1);
		}else if(vhnumStr.length()==3) {
			//����Ϊ3 ������Ϊ2λ��¥��Ϊ2�ǡ�  ���Զ�Ҫ������4λ�� ��Ϊ7λ�� �����ѯʱ������ǰ3λ����¥�㣬��4λ������
			houseTempVhdisplayno = vhnumStr.substring(0, 1) + "00" + vhnumStr.substring(1);
			houseTempVhdisplayno = "00" + houseTempVhdisplayno; 
		} else if(vhnumStr.length()==4) {
			//����Ϊ4ʱ,ǰ��λ����Ϊ¥�㣬 Ҳ���ܺ���λΪ���š� 
			//if(Integer.parseInt(infloor)==Integer.parseInt(vhnumStr.substring(0,2))) {
			if(String.valueOf(infloor).equalsIgnoreCase(floorOfHouseNum)) {
				houseTempVhdisplayno = vhnumStr.substring(0,2) + "00" + vhnumStr.substring(2);
				houseTempVhdisplayno = "0" + houseTempVhdisplayno;
			} else {
				if("0".equals(vhnumStr.substring(0,1).trim())){
					  houseTempVhdisplayno = vhnumStr.substring(0,1) + "0" + vhnumStr.substring(1);
					  }else{
						  houseTempVhdisplayno="0"+vhnumStr;
					  }
					houseTempVhdisplayno = "00" + houseTempVhdisplayno;
				}
		} else if(vhnumStr.length()==5) {
			//����Ϊ5 ʱ �� ǰ��λ����Ϊ¥�㣬 Ҳ����ǰ��λΪ¥�� ���� ��һλΪ¥�㡣 
			//if(Integer.parseInt(infloor) == Integer.parseInt(vhnumStr.substring(0,2))) {
			if(String.valueOf(infloor).equalsIgnoreCase(floorOfHouseNum)) {
				houseTempVhdisplayno = vhnumStr.substring(0,2) + "0" + vhnumStr.substring(2);
				houseTempVhdisplayno = "0" + houseTempVhdisplayno;
			} else if(Integer.parseInt(infloor)==Integer.parseInt(vhnumStr.substring(0,3))) {
				houseTempVhdisplayno = vhnumStr.substring(0,3) + "00" + vhnumStr.substring(3);
			} else {
				houseTempVhdisplayno = "00" + vhnumStr;
			}
		} else if(vhnumStr.length()==6) {
			//����Ϊ6 ʱ ��ǰ��λ����Ϊ¥�㣬 Ҳ����ǰ��λΪ¥��
			//if(Integer.parseInt(infloor) == Integer.parseInt(vhnumStr.substring(0,2))) {
			if(String.valueOf(infloor).equalsIgnoreCase(floorOfHouseNum)) {
				houseTempVhdisplayno = "0" + vhnumStr;
			} else if(Integer.parseInt(infloor) == Integer.parseInt(vhnumStr.substring(0,3))) {
				houseTempVhdisplayno = vhnumStr.substring(0,3) + "0" + vhnumStr.substring(3);
			}
		} else {
			houseTempVhdisplayno = vhnumStr;
		}
		return houseTempVhdisplayno;
	}
}
