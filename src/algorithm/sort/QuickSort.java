package algorithm.sort;

/**
 * 快速排序算法
 *
 */
public class QuickSort {

	static void quickSort(int[] arr,int left,int right)			//快速排序算法
	{
	    int f,t;
		int rtemp,ltemp;

	    ltemp=left;
	    rtemp=right;
	    f=arr[(left+right)/2];						//分界值
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
			quickSort(arr,left,ltemp-1);			//递归调用
		}
	    if(ltemp<right) 
		{
			quickSort(arr,rtemp+1,right);			//递归调用
		}
	}
	public static void main(String[] args) 
	{
		int[] shuzu = { 9, 45, 23, 14, 67, 98, 3 }; // 初始化数组
		int i;
		System.out.print("排序前的数组为：\n"); // 输出排序前的数组
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " ");
		}
		System.out.print("\n");
		quickSort(shuzu,0,shuzu.length-1); // 排序操作
		System.out.print("排序后的数组为：\n");
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " "); // 输出排序后的数组
		}
		System.out.print("\n");
	}

}
