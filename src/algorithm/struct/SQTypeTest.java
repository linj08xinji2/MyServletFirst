package algorithm.struct;
import java.util.Scanner;

/**
 * 
 * 队列
 *
 */
class SQType
{
	static final int QUEUELEN=15;
    DATA[] data=new DATA[QUEUELEN]; 					//队列数组 
    int head; 								//队头 
    int tail; 								//队尾 
    
    @SuppressWarnings("unused")
	SQType SQTypeInit()
    {
    SQType q;

        if((q=new SQType())!=null) 		//申请内存 
        {
            q.head = 0;						//设置队头 
            q.tail = 0;							//设置队尾 
            return q;
        }
    	else
    	{
            return null; 						//返回空
    	}
    }

    int SQTypeIsEmpty(SQType q)  				//判断空队列
    {
    	int temp=0;
    	if(q.head==q.tail)
    		temp=1;
        return (temp);
    }

    int SQTypeIsFull(SQType q)					// 判断满队列
    {
    	int temp=0;
    	if(q.tail==QUEUELEN)
    		temp=1;
        return (temp);
    }

    void SQTypeClear(SQType q)  				//清空队列 
    {
        q.head = 0;							//设置队头 
        q.tail = 0;								//设置队尾 
    }

    void SQTypeFree(SQType q) 					//释放队列
    {
        if (q!=null)
    	{
           q=null;
    	}
    }

    int InSQType(SQType q,DATA data)			//入队列
    {	
        if(q.tail==QUEUELEN)
        { 
            System.out.print("队列已满!操作失败!\n");
            return(0);
        }
    	else
    	{
            q.data[q.tail++]=data;				//将元素入队列
            return(1);
        }
    }

    DATA OutSQType(SQType q) 				//出队列
    {
        if(q.head==q.tail)
        {
            System.out.print("\n队列已空!操作失败!\n");
            
            System.exit(0);
        }
    	else
    	{
            return q.data[q.head++];
        }
		return null;
    }

    DATA PeekSQType(SQType q) 				//读结点数据
    {
        if(SQTypeIsEmpty(q)==1)
        {
            System.out.print("\n空队列!\n");
            return null; 
        }
    	else
    	{
            return q.data[q.head];
        }
    }

    int SQTypeLen(SQType q) 					//计算队列长度 
    {
    	int temp;
    	temp=q.tail-q.head;
        return (temp);
    }
    
}

public class SQTypeTest {

	private static Scanner input;

	public static void main(String[] args) {
		SQType st=new SQType();
	   
		DATA data1;    
		
		input = new Scanner(System.in);
	    SQType stack=st.SQTypeInit();  					//初始化队列
	    System.out.print("入队列操作：\n");
	    System.out.println("输入姓名 年龄进行入队列操作:"); 
		do
		{	
			DATA data=new DATA();
			data.name=input.next();
			data.age=input.nextInt();
			if(data.name.equals("0")) 
			{
				break; 						//若输入0，则退出
			}
			else
			{
				st.InSQType(stack,data);
			}
		}while(true);


		String temp="1";
		System.out.println("出队列操作:按任意非0键进行出栈操作:");
		temp=input.next();
		while(!temp.equals("0"))
		{
		   	data1=st.OutSQType(stack);
			System.out.printf("出队列的数据是(%s,%d)\n" ,data1.name,data1.age);	
			temp=input.next();
		}
		System.out.println("测试结束！");
	    st.SQTypeFree(stack); 					//释放队列所占用的空间 

	}

}
