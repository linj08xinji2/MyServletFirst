package algorithm.search;

/**
 * 顺序查找
 *
 */
public class SeqSearch {
	static int searchFun(int a[],int n,int x)	//顺序查找函数
	{
	    int i,f=-1;

		for(i=0;i<n;i++)
		{
		    if(x==a[i])
		    {
				f=i;
				break;						//退出
			}
		}

		return f;
	}

	public static void main(String[] args) {
		int x,n,i;
		int[] shuzu = { 9, 45, 23, 14, 67, 98, 3 }; // 初始化数组

		System.out.print("顺序查找算法演示！\n");
	    System.out.print("数据序列:\n");
	    for(i=0;i<shuzu.length;i++)
		{
	        System.out.print(" "+shuzu[i]);					//输出序列
		}
		System.out.print("\n\n");
	    System.out.print("输入要查找的数:");
         x=3;
	    n=searchFun(shuzu,shuzu.length,x);					//查找

	    if(n<0)								//输出查找结果
		{
			System.out.println("没找到数据:"+x);
		}
		else
		{
			System.out.println("数据:"+x+" 位于数组的第"+(n+1)+" 个元素处。");
		}

	}

}
