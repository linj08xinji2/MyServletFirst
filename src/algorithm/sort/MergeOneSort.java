package algorithm.sort;
/**
 * 合并排序
 *
 */
public class MergeOneSort {
	static void mergeOne(int a[],int b[],int n,int len) 		//完成一遍合并的函数 
	{
	    int i,j,k,s,e;

	    s=0;
	    while(s+len<n)  
	    {
	        e=s+2*len-1;
	        if(e>=n) 						//最后一段可能少于len个结点 
			{
	            e=n-1;
			}
			//相邻有序段合并
			k=s;
			i=s;
			j=s+len;
			while(i<s+len && j<=e) 			//如果两个有序表都未结束时，循环比较 
			{
				if(a[i]<=a[j])				//如果较小的元素复制到数组b中 
				{
				   b[k++]=a[i++];
				}
				else
				{
					b[k++]=a[j++];
				}
			}
			while(i<s+len)					//未合并的部分复制到数组b中 
			{
				b[k++]=a[i++];
			}
			while(j<=e)
			{
			   b[k++]=a[j++]; 				//未合并的部分复制到数组b中 
			}

	        s=e+1; 						//下一对有序段中左段的开始下标 
	    }
	    if(s<n) 							//将剩余的一个有序段从数组A中复制到数组b中
		{
	        for(;s<n;s++)
			{
	            b[s]=a[s];
			}
		}
	}
	static void mergeSort(int a[],int n)				//合并排序
	{
//	    int *p;
		int h,count,len,f;

		count=0;							//排序步骤
	    len=1;     						//有序序列的长度 
	    f=0;								//变量f作标志
//	    if(!(p=(int *)malloc(sizeof(int)*n)))		//分配内存空间
//	    {
//	        printf("内存分配失败!\n");
//	        exit(0); 
//	    }
	    int[] p=new int[n];
	    while(len<n)
	    {
	        if(f==1)   						//交替在A和P之间合并 
			{
	            mergeOne(p,a,n,len);			//p合并到a
			}
	        else
			{
	            mergeOne(a,p,n,len);			//a合并到p
			}
	        len=len*2;						//增加有序序列长度
	        f=1-f; 							//使f值在0和1之间切换 

			count++;
			System.out.printf("第"+count+"步排序结果:");	//输出每步排序的结果
			for(h=0;h<a.length;h++)
			{
				System.out.printf(" "+a[h]);			//输出
			}
			System.out.print("\n");

	    }
	    if(f==1)								//如果进行了排序
		{
	        for(h=0;h<n;h++)					//将内存p中的数据复制回数组a
			{
	            a[h]=p[h];
			}
		}
//	    free(p); 							//释放内存 
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
		mergeSort(shuzu,shuzu.length); // 排序操作
		System.out.print("排序后的数组为：\n");
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " "); // 输出排序后的数组
		}
		System.out.print("\n");
	
	}

}
