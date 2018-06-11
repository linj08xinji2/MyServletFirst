package algorithm.struct;
import java.util.Scanner;

/**
 * 
 *栈
 *
 */

class StackType
{
	static final int MAXLEN=50;
    DATA[] data=new DATA[MAXLEN+1]; 						//数据元素 
    int top; 								//栈顶 
    
    @SuppressWarnings("unused")
	StackType STInit()
    {
    	StackType p;
    	
        if((p=new StackType())!=null) 	//申请栈内存 
        {
            p.top=0; 							//设置栈顶为0 
            return p;							//返回指向栈的指针 
        }
        return null;
    }

    boolean STIsEmpty(StackType s) 					//判断栈是否为空 
    {
    	boolean t;
    	t=(s.top==0);
        return t;
    }

    boolean STIsFull(StackType s) 					//判断栈是否已满
    {
    	boolean t;
    	t=(s.top==MAXLEN);
        return t;
    }

    void STClear(StackType s)  					//清空栈 
    {
        s.top=0;
    }

    void STFree(StackType s) 					//释放栈所占用空间 
    {
        if(s!=null)
    	{
            s=null;
    	}
    }

    int PushST(StackType s,DATA data)			//入栈操作 
    {
         if((s.top+1)>MAXLEN)
         {
             System.out.print("栈溢出!\n"); 
             return 0;
         }
         s.data[++s.top]=data;					//将元素入栈
         return 1; 
    }

    DATA PopST(StackType s) 					//出栈操作 
    {
         if(s.top==0)
         {
             System.out.print("栈为空!\n");
//             
             System.exit(0);
         }
         return (s.data[s.top--]);
    }

    DATA PeekST(StackType s) 					//读栈顶数据
    {
         if(s.top==0)
         {
             System.out.printf("栈为空!\n");
//             
             System.exit(0);
         }
         return (s.data[s.top]);
    }
}

public class StackTypeTest {

	private static Scanner input;

	public static void main(String[] args) {
		StackType st=new StackType();
	    DATA data1=new DATA();    

	    StackType stack=st.STInit();  						//初始化栈
	    input = new Scanner(System.in);
	    System.out.print("入栈操作：\n");
	    System.out.println("输入姓名 年龄进行入栈操作:"); 
		do
		{
			DATA data=new DATA();
			data.name=input.next();
			
			if(data.name.equals("0")) 
			{
				break; 						//若输入0，则退出
			}
			else
			{
				data.age=input.nextInt();
				st.PushST(stack,data);
			}
		}while(true);
		
		String temp="1";
		System.out.println("出栈操作:按任意非0键进行出栈操作:");
		temp=input.next();
		while(!temp.equals("0"))
		{
		   	data1=st.PopST(stack);
			System.out.printf("出栈的数据是(%s,%d)\n" ,data1.name,data1.age);	
			temp=input.next();
		}
		System.out.println("测试结束！");
	    st.STFree(st); 							//释放栈所占用的空间 

	}

}
