package test;

import java.util.ArrayList;
import java.util.List;

public class B {

	public static void main(String[] args) {
		
     List<String> all=new ArrayList<String>();
     all.add("a");
     all.add("b");
     all.add("c");
     all.add("d");
     all.add("e");
     all.add("f");
     all.add("g");
     all.add("h");
     List<String> remove=new ArrayList<String>();
//     remove.add("1");
//     remove.add("2");
//     remove.add("3");
//     remove.add("a");
//     remove.add("b");
//     remove.add("c");
//     remove.add("d");
//     remove.add("e");
//     remove.add("f");
//     remove.add("g");
//     remove.add("h");
     List<String> sa=new ArrayList<String>();
	for (String alla : all) {
		for (String removea : remove) {
			if(alla.equals(removea)){
				sa.add(alla);
			}
		}
	}	
		all.removeAll(remove);
		System.out.println(sa);
		System.out.println(all);
		
		
//		String a = ""; // ÄÐ;Å®
//		if (null != a && !"".equals(a)) {
//			if (a.startsWith(";") || a.startsWith("£»")) {
//				System.out.println(a.substring(1, 2));
//			} else {
//				System.out.println(a.substring(0, 1));
//			}
//		}

		/*
		 * String a="£»1968-05-17"; // 1965-03-20;1968-05-17 if (null != a &&
		 * !"".equals(a)) { if(a.startsWith(";")||a.startsWith("£»")){
		 * System.out.println(a.substring(1, 11)); }else{
		 * System.out.println(a.substring(0, 10)); } }
		 */
	}
}
