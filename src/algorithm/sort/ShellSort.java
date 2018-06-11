package algorithm.sort;

/**
 * Shell����
 *
 */
public class ShellSort 
{

	static void shellSort(int[] a)  //Shell����
	{
	    int i,j,h;
	    int r,temp;
		int x=0;

	    for(r=a.length/2;r>=1;r/= 2)						//��������
		{
	    	for(i=r;i<a.length;i++)
	    	{
				temp=a[i];
				j=i-r;
				while(j>=0 && temp<a[j])
				{
					a[j+r]=a[j];
					j-=r;
				}
				a[j+r]=temp;
			}

			x++;
			System.out.print("��"+x+"��������:");			//���ÿ������Ľ��
			for(h=0;h<a.length;h++)
			{
				System.out.print(" "+a[h]);				//���
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
		shellSort(shuzu); // �������
		System.out.print("����������Ϊ��\n");
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " "); // �������������
		}
		System.out.print("\n");
	}

}
