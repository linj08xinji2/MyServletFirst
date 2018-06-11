package algorithm.struct;
import java.util.Scanner;

/**
 * 
 * ����
 *
 */
class SQType
{
	static final int QUEUELEN=15;
    DATA[] data=new DATA[QUEUELEN]; 					//�������� 
    int head; 								//��ͷ 
    int tail; 								//��β 
    
    @SuppressWarnings("unused")
	SQType SQTypeInit()
    {
    SQType q;

        if((q=new SQType())!=null) 		//�����ڴ� 
        {
            q.head = 0;						//���ö�ͷ 
            q.tail = 0;							//���ö�β 
            return q;
        }
    	else
    	{
            return null; 						//���ؿ�
    	}
    }

    int SQTypeIsEmpty(SQType q)  				//�жϿն���
    {
    	int temp=0;
    	if(q.head==q.tail)
    		temp=1;
        return (temp);
    }

    int SQTypeIsFull(SQType q)					// �ж�������
    {
    	int temp=0;
    	if(q.tail==QUEUELEN)
    		temp=1;
        return (temp);
    }

    void SQTypeClear(SQType q)  				//��ն��� 
    {
        q.head = 0;							//���ö�ͷ 
        q.tail = 0;								//���ö�β 
    }

    void SQTypeFree(SQType q) 					//�ͷŶ���
    {
        if (q!=null)
    	{
           q=null;
    	}
    }

    int InSQType(SQType q,DATA data)			//�����
    {	
        if(q.tail==QUEUELEN)
        { 
            System.out.print("��������!����ʧ��!\n");
            return(0);
        }
    	else
    	{
            q.data[q.tail++]=data;				//��Ԫ�������
            return(1);
        }
    }

    DATA OutSQType(SQType q) 				//������
    {
        if(q.head==q.tail)
        {
            System.out.print("\n�����ѿ�!����ʧ��!\n");
            
            System.exit(0);
        }
    	else
    	{
            return q.data[q.head++];
        }
		return null;
    }

    DATA PeekSQType(SQType q) 				//���������
    {
        if(SQTypeIsEmpty(q)==1)
        {
            System.out.print("\n�ն���!\n");
            return null; 
        }
    	else
    	{
            return q.data[q.head];
        }
    }

    int SQTypeLen(SQType q) 					//������г��� 
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
	    SQType stack=st.SQTypeInit();  					//��ʼ������
	    System.out.print("����в�����\n");
	    System.out.println("�������� �����������в���:"); 
		do
		{	
			DATA data=new DATA();
			data.name=input.next();
			data.age=input.nextInt();
			if(data.name.equals("0")) 
			{
				break; 						//������0�����˳�
			}
			else
			{
				st.InSQType(stack,data);
			}
		}while(true);


		String temp="1";
		System.out.println("�����в���:�������0�����г�ջ����:");
		temp=input.next();
		while(!temp.equals("0"))
		{
		   	data1=st.OutSQType(stack);
			System.out.printf("�����е�������(%s,%d)\n" ,data1.name,data1.age);	
			temp=input.next();
		}
		System.out.println("���Խ�����");
	    st.SQTypeFree(stack); 					//�ͷŶ�����ռ�õĿռ� 

	}

}
