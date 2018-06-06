package callBack;

public class Student {
	private String name = null;

	public Student(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*@SuppressWarnings("unused")
	private int calcADD(int a, int b) {
		return a + b;
	}

	private int useCalculator(int a, int b) {
		return new Calculator().add(a, b);
	}

	public void fillBlank(int a, int b) {
		int result = useCalculator(a, b);
		System.out.println(name + "����:" + a + " + " + b + " = " + result);
	}*/

	/**
	 * ִ������Ϊ��С��ͨ�������callHelp����������С�죨new SuperCalculator()����add������
	 * �ڵ��õ�ʱ����������ã�this����������һ�����룬
	 * С����ʹ�ü������ó����֮��
	 * �ص���С����fillBlank����������������˺ڰ��ϵĿո��
	 * @param a
	 * @param b
	 */
	public void callHelp(int a, int b) {
		new SuperCalculator().add(a, b, new doHomeWork());  //  this
	}
	
	public class doHomeWork implements doJob{

		@Override
		public void fillBlank(int a, int b, int result) {
			System.out.println(name + "����С�����:" + a + " + " + b + " = " + result);
		}
		
	}
	
}
