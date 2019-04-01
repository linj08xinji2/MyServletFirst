package algorithmWeiXin;

/**
 * ½ğ¶î×ª»»ÎÊÌâ

 *
 */
public class RenMingBI {

	private static final char[] data = new char[] { 'Áã', 'Ò¼', '·¡', 'Èş', 'ËÁ',
			'Îé', 'Â½', 'Æâ', '°Æ', '¾Á' };
	private static final char[] units = new char[] { 'Ôª', 'Ê°', '°Û', 'Çª', 'Íò',
			'Ê°', '°Û', 'Çª', 'ÒÚ' };

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
