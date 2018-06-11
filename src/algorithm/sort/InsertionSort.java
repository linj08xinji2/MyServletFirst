package algorithm.sort;

/**
 * 插入排序
 *
 */
public class InsertionSort 
{
	static void insertionSort(int[] a)  				//插入排序
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

			System.out.print("第"+i+"步排序结果:");			//输出每步排序的结果
			for(h=0;h<a.length;h++)
			{
				System.out.print(" "+a[h]);				//输出
			}
			System.out.print("\n");
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
		insertionSort(shuzu); // 排序操作
		System.out.print("排序后的数组为：\n");
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " "); // 输出排序后的数组
		}
		System.out.print("\n");
	}

}
