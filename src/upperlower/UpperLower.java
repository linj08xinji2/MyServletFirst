package upperlower;

public class UpperLower {

	public static void main(String[] args) {
//		 String a="��ԪAABe";
//		 a=a.toLowerCase();
//         String b="aabbcc";
//         b= b.toUpperCase();
//         System.out.println(a);
//         System.out.println(b);
		
		UpperLowerVO vo=new UpperLowerVO();
		vo.setPk_myhousecusid("aaabbcc");
        vo.setPk_myprojectid("EEEFFGGG");
		vo.setVhcell("��Ԫ");
         System.out.println(vo);
	}

}
