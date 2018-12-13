package my.test.lambda;

public class LambdaDemo {

	 interface Printer{
		 void print(String val);
	 }
	
	 public void printSomething(Printer printer,String something){
		 printer.print(something);
	 }
	 
	public static void main(String[] args) {
		LambdaDemo lambdaDemo = new LambdaDemo();
		String something = "I am learing lambda";
		// 正常情况
		/*
		 * Printer printer=new Printer() {
		 * 
		 * @Override public void print(String val) { System.out.println(val); }
		 * };
		 */
		// lambda表达式
		// Printer printer = (String toPrint)->{System.out.println(toPrint);};
		// Printer printer = (toPrint)->{System.out.println(toPrint);};
//		Printer printer = toPrint -> System.out.println(toPrint);
//		lambdaDemo.printSomething(printer, something);
	}
}
