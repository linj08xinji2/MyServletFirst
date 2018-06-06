package nc.bs.pub.action;


/**
 * String 加解密 目前存在一个问题，字符串长度小，加密的长度就小
 * 
 * @version 1.0 02/10/99
 * @author wang shuang
 * 
 */
public class Encode {
	/**
	 * 解密
	 * 
	 * 
	 */
	public String decode(String s) {
		if (s == null)
			return null;
		String res = "";
		DES des = new DES(getKey());
		byte[] sBytes = s.getBytes();
		for (int i = 0; i < (sBytes.length / 16); i++) {
			byte[] theBytes = new byte[8];
			for (int j = 0; j <= 7; j++) {
				byte byte1 = (byte) (sBytes[16 * i + 2 * j] - 'a');
				byte byte2 = (byte) (sBytes[16 * i + 2 * j + 1] - 'a');
				theBytes[j] = (byte) (byte1 * 16 + byte2);
			}
			long x = des.bytes2long(theBytes);
			byte[] result = new byte[8];
			des.long2bytes(des.decrypt(x), result);
			res = res + (new String(result));
		}
		return res.trim();
	}

	/**
	 * 加密
	 * 
	 * 
	 */
	public String encode(String s) {
		if (s == null)
			return null;
		String res = "";
		DES des = new DES(getKey());
		byte space = 0x20;
		byte[] sBytes = s.getBytes();
		int length = sBytes.length;
		int newLength = length + (8 - length % 8) % 8;
		byte[] newBytes = new byte[newLength];
		for (int i = 0; i < newLength; i++) {
			if (i <= length - 1) {
				newBytes[i] = sBytes[i];
			} else {
				newBytes[i] = space;
			}
		}
		for (int i = 0; i < (newLength / 8); i++) {
			byte[] theBytes = new byte[8];
			for (int j = 0; j <= 7; j++) {
				theBytes[j] = newBytes[8 * i + j];
			}
			long x = des.bytes2long(theBytes);
			byte[] result = new byte[8];
			des.long2bytes(des.encrypt(x), result);
			byte[] doubleResult = new byte[16];
			for (int j = 0; j < 8; j++) {
				doubleResult[2 * j] = (byte) (((((char) result[j]) & 0xF0) >> 4) + 'a');
				doubleResult[2 * j + 1] = (byte) ((((char) result[j]) & 0x0F) + 'a');
			}
			res = res + new String(doubleResult);
		}
		return res;
	}

	/**
	 * 固定的加密Key
	 * 
	 * @return long
	 */
	private static long getKey() {
		return 1231234234;
	}

	public static void main(String[] args) {
//		System.out.println("linjing:" + new Encode().encode("1"));
		/*System.out.println("linqihong:" + new Encode().encode("linqihong"));
		System.out.println("ningdarui:" + new Encode().encode("ningdarui"));
		System.out.println("baomiankai:" + new Encode().encode("baomiankai"));
		System.out.println("lanchun:" + new Encode().encode("lanchun"));
		System.out.println("pengweidong:" + new Encode().encode("pengweidong"));
		System.out.println("liuchen:" + new Encode().encode("liuchen"));
		System.out.println("wuhaihui:" + new Encode().encode("wuhaihui"));*/
		System.out.println(new Encode().decode("jccnfealbhanfmma"));
	}

}
