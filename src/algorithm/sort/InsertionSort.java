package algorithm.sort;

/**
 * ��������
 *
 */
public class InsertionSort 
{
	static void insertionSort(int[] a)  				//��������
	{
	    int i,j,t,h;
	    for (i=1;i<a.length;i++)
	    {
			t=a[i];
			j=i-1;
			while(j>=0 && t<a[j])
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=t;

			System.out.print("��"+i+"��������:");			//���ÿ������Ľ��
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
		insertionSort(shuzu); // �������
		System.out.print("����������Ϊ��\n");
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " "); // �������������
		}
		System.out.print("\n");
	}

}
