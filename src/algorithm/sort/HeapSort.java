package algorithm.sort;
/**
 * ������
 *
 */
public class HeapSort {
	
	static void heapSort(int a[],int n)					//������
	{
	    int i,j,h,k;
	    int t;

	    for(i=n/2-1;i>=0;i--)    				//��a[0,n-1]���ɴ����
		{
			while(2*i+1<n) 					//��i������������� 
			{
				j=2*i+1 ;
				if((j+1)<n)
				{            
				    if(a[j]<a[j+1])			//��������С��������������Ҫ�Ƚ�������
				        j++; 				//�������1��ָ�������� 
				}
				if(a[i]<a[j])					//�Ƚ�i��jΪ��ŵ�����
				{            
				    t=a[i];  				//�������� 
					a[i]=a[j];
					a[j]=t;            
					i=j ;					//�ѱ��ƻ�����Ҫ���µ���
				}
				else 					//�Ƚ������ӽ��������δ�ƻ���������Ҫ����
				{
					break;
				}
			}
		}
		//������ɵĶ�
		System.out.print("ԭ���ݹ��ɵĶ�:");		
		for(h=0;h<n;h++)
		{
			System.out.print(" "+a[h]);				//���
		}
		System.out.print("\n");

	    for(i=n-1;i>0;i--)
	    {
	        t=a[0];							//���i����¼����
	        a[0] =a[i];
	        a[i] =t;
			k=0;
			while(2*k+1<i) 					//��i������������� 
			{
				j=2*k+1 ;
				if((j+1)<i)
				{            
				    if(a[j]<a[j+1])			//��������С��������������Ҫ�Ƚ�������
					{
				        j++; 				//�������1��ָ�������� 
					}
				}
				if(a[k]<a[j])				//�Ƚ�i��jΪ��ŵ�����
				{            
				    t=a[k];  				//�������� 
					a[k]=a[j];
					a[j]=t;            
					k=j ;					//�ѱ��ƻ�����Ҫ���µ���
				}
				else 					//�Ƚ������ӽ��������δ�ƻ���������Ҫ����
				{
					break;
				}
			}

			System.out.print("��"+(n-i)+"��������:");		//���ÿ������Ľ��
			for(h=0;h<n;h++)
			{
				System.out.print(" "+a[h]);			//���
			}
			System.out.print("\n");
	    }  
	}
	public static void main(String[] args)
	{

		int[] shuzu = { 9, 45, 23, 14, 67, 98, 3 }; // ��ʼ������
		int i;
		System.out.print("����ǰ������Ϊ��\n"); // �������ǰ������
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " ");
		}
		System.out.print("\n");
		heapSort(shuzu,shuzu.length); // �������
		System.out.print("����������Ϊ��\n");
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " "); // �������������
		}
		System.out.print("\n");
	
	}

}
