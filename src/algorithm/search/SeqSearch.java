package algorithm.search;

/**
 * ˳�����
 *
 */
public class SeqSearch {
	static int searchFun(int a[],int n,int x)	//˳����Һ���
	{
	    int i,f=-1;

		for(i=0;i<n;i++)
		{
		    if(x==a[i])
		    {
				f=i;
				break;						//�˳�
			}
		}

		return f;
	}

	public static void main(String[] args) {
		int x,n,i;
		int[] shuzu = { 9, 45, 23, 14, 67, 98, 3 }; // ��ʼ������

		System.out.print("˳������㷨��ʾ��\n");
	    System.out.print("��������:\n");
	    for(i=0;i<shuzu.length;i++)
		{
	        System.out.print(" "+shuzu[i]);					//�������
		}
		System.out.print("\n\n");
	    System.out.print("����Ҫ���ҵ���:");
         x=3;
	    n=searchFun(shuzu,shuzu.length,x);					//����

	    if(n<0)								//������ҽ��
		{
			System.out.println("û�ҵ�����:"+x);
		}
		else
		{
			System.out.println("����:"+x+" λ������ĵ�"+(n+1)+" ��Ԫ�ش���");
		}

	}

}
