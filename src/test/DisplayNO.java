package test;

public class DisplayNO {

	public static void main(String[] args) {
		System.out.println(getdisplayno("01","1"));;
	}

	
	private static String getdisplayno(String vhnumStr1, String infloor) {
		//edited by rengb 去掉空格
		String vhnumStr = vhnumStr1.trim();
		
		String houseTempVhdisplayno="";
		String floorOfHouseNum = null;
		try{
			Integer floor = Integer.parseInt(vhnumStr.substring(0,2));
			floorOfHouseNum = String.valueOf(floor);
		}catch(Exception e){
			floorOfHouseNum = String.valueOf(vhnumStr.substring(0,2));
		}
		//add by zhangws 对于房号只有2位的情况，生成显示编码规则‘2A‘---’002000A‘
		if(vhnumStr.length()==2){
			houseTempVhdisplayno = "00"+vhnumStr.substring(0, 1)+"000"+vhnumStr.substring(1);
		}else if(vhnumStr.length()==3) {
			//长度为3 代表房号为2位、楼层为2们。  所以都要补齐至4位。 总为7位。 方便查询时解析－前3位代表楼层，后4位代表房号
			houseTempVhdisplayno = vhnumStr.substring(0, 1) + "00" + vhnumStr.substring(1);
			houseTempVhdisplayno = "00" + houseTempVhdisplayno; 
		} else if(vhnumStr.length()==4) {
			//长度为4时,前两位可能为楼层， 也可能后三位为房号。 
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
			//长度为5 时 ， 前两位可能为楼层， 也可能前三位为楼层 或者 第一位为楼层。 
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
			//长度为6 时 ，前两位可能为楼层， 也可能前三位为楼层
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
