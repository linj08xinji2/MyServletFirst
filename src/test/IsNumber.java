package test;

public class IsNumber {

	public static void main(String[] args) {
		String a="36252319740815321X";
		a=a.replace(";", "£»");
		System.out.println(a);
//		if(null!=a&&!isNumeric(a)){
//			System.out.println("wrong");
//		}
//		System.out.println("conutine");
	}

	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
