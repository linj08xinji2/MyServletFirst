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
		System.out.println(name + "心算:" + a + " + " + b + " = " + result);
	}*/

	/**
	 * 执行流程为：小明通过自身的callHelp方法调用了小红（new SuperCalculator()）的add方法，
	 * 在调用的时候将自身的引用（this）当做参数一并传入，
	 * 小红在使用计算器得出结果之后，
	 * 回调了小明的fillBlank方法，将结果填在了黑板上的空格里。
	 * @param a
	 * @param b
	 */
	public void callHelp(int a, int b) {
		new SuperCalculator().add(a, b, new doHomeWork());  //  this
	}
	
	public class doHomeWork implements doJob{

		@Override
		public void fillBlank(int a, int b, int result) {
			System.out.println(name + "求助小红计算:" + a + " + " + b + " = " + result);
		}
		
	}
	
}
