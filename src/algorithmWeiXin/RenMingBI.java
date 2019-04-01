package algorithmWeiXin;

/**
 * ���ת������

 *
 */
public class RenMingBI {

	private static final char[] data = new char[] { '��', 'Ҽ', '��', '��', '��',
			'��', '½', '��', '��', '��' };
	private static final char[] units = new char[] { 'Ԫ', 'ʰ', '��', 'Ǫ', '��',
			'ʰ', '��', 'Ǫ', '��' };

	public static void main(String[] args) {
		String out = Conver(123456);
		System.out.println("result:"+out);
	}

	private static String Conver(int money) {
		StringBuffer sBuffer = new StringBuffer();
		int unit = 0;
		while (money != 0) {
			sBuffer.insert(0, units[unit++]);
			int number = money % 10;
//			System.out.println(number);
			sBuffer.insert(0, data[number]);
			money /= 10;
//			System.out.println(money);
		}
		return sBuffer.toString();
	}

}
