package test;

public class NullEmpty {

	public static void main(String[] args) {
//            if("".equals(null)){
//            	System.out.println("true");
//            }else{
//            	System.out.println("false");
//            }
         int []pk_housecusid=new int[3];
         System.out.println(pk_housecusid.length);
        if(pk_housecusid.length < 3){
        	System.out.println("OK");
        } else {
        	System.out.println("no bad");
        }
            
	}

}
