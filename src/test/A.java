package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A {

	public static void main(String[] args) {/*
		Map<String, String> map = new HashMap<String, String>();
		map.put("aa", null);
		if ("3".equals(String.valueOf(map.get("aa")))) {
			System.out.println("aaa");
		} else {
			System.out.println("bbb");

		}
	*/
		/*String ufdatenew = "2016-01-01";
		String ufdatenew2 = ufdatenew.substring(0, 5) + "02"+ ufdatenew.substring(7, 10);
		System.out.println(ufdatenew2);
		Object ufdatenew3 = "2016-01-01";
		if("2016-01-01".equals(ufdatenew3)){
			System.out.println("over");
		}*/
	
		List<String> list=new ArrayList<String>();
				list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		deleteList(list);
		for (String string : list) {
			System.out.println("w:"+string);
		}
		
		/*while(list.size()>1){
			System.out.println("before:"+list);
			  list.remove(0);
			  System.out.println("after:"+list);
		}*/
		/*for (int i = 0; i < list.size(); i++) {
			System.out.println("before:"+list);
			  list.remove(list.get(0));
			System.out.println("after:"+list);
		}*/
//		System.out.println("end:"+list);
//		if(isNumeric("a00123445")){
//			System.out.println("number");
//		}else{
//			System.out.println("no number");
//		}
		
	}
	
	private static void deleteList(List<String> list) {
		List<String> list2=new ArrayList<String>();
		list2.add("d");
		list2.add("e");
		list.removeAll(list2);
	}

	public static boolean isNumeric(String str){
		  for (int i = str.length();--i>=0;){   
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }


}
