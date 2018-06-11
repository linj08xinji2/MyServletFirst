package algorithm.sort;

/**
 * 冒泡排序法
 *
 */
public class BubbleSort {

	public static void bubbleSort(int[] a) {
		int temp;
		for (int i = 1; i < a.length; i++) {
			// 将相邻两个数进行比较，较大的数往后冒泡
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j + 1]) {
					// 交换相邻两个数
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			System.out.print("第" + i + "步排序结果:"); // 输出每步排序的结果
			for (int k = 0; k < a.length; k++) {
				System.out.print(" " + a[k]); // 输出
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		int[] shuzu = { 9, 45, 23, 14, 67, 98, 3 }; // 初始化数组
		int i;
		System.out.print("排序前的数组为：\n"); // 输出排序前的数组
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " ");
		}
		System.out.print("\n");
		bubbleSort(shuzu); // 排序操作
		System.out.print("排序后的数组为：\n");
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " "); // 输出排序后的数组
		}
		System.out.print("\n");

	}

}
