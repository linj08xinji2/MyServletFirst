package test;

public class MaxTime {

	public static void main(String[] args) {
		Long t1=System.currentTimeMillis();
		for (int i = 0; i < 288*22; i++) {
			System.out.println(i);
		}
        long t2=System.currentTimeMillis();
        System.out.println("take time:"+ (t2-t1));
	}

}
