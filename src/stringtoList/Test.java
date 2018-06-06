package stringtoList;

import java.text.SimpleDateFormat;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String abc = "";
		String[] arr = abc.split(",");
//		System.out.println(arr);
		for (String string : arr) {
			System.out.println(string);
		}
		List<String> list = java.util.Arrays.asList(arr);
		for (String string : list) {
//			System.out.println(string);
		}
//		System.out.println(list);
//		SimpleDateFormat  sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//         long t=System.currentTimeMillis();
//         System.out.println(sf.format(t));
	}

}
