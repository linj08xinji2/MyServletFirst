package algorithm.sort;

/**
 * ���������㷨
 *
 */
public class QuickSort {

	static void quickSort(int[] arr,int left,int right)			//���������㷨
	{
	    int f,t;
		int rtemp,ltemp;

	    ltemp=left;
	    rtemp=right;
	    f=arr[(left+right)/2];						//�ֽ�ֵ
		while(ltemp<rtemp)
		{
	        while(arr[ltemp]<f)
			{
				++ltemp;
			}
	        while(arr[rtemp]>f) 
			{
				--rtemp;
			}
	        if(ltemp<=rtemp)
	        {
				t=arr[ltemp];
		        arr[ltemp]=arr[rtemp];
	    	    arr[rtemp]=t;
				--rtemp;
	        	++ltemp;
			}
	    }
	    if(ltemp==rtemp) 
		{
			ltemp++;
		}

	    if(left<rtemp) 
		{
			quickSort(arr,left,ltemp-1);			//�ݹ����
		}
	    if(ltemp<right) 
		{
			quickSort(arr,rtemp+1,right);			//�ݹ����
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
		quickSort(shuzu,0,shuzu.length-1); // �������
		System.out.print("����������Ϊ��\n");
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " "); // �������������
		}
		System.out.print("\n");
	}

}
