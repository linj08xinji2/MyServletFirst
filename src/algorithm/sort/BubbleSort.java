package algorithm.sort;

/**
 * ð������
 *
 */
public class BubbleSort {

	public static void bubbleSort(int[] a) {
		int temp;
		for (int i = 1; i < a.length; i++) {
			// ���������������бȽϣ��ϴ��������ð��
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j + 1]) {
					// ��������������
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			System.out.print("��" + i + "��������:"); // ���ÿ������Ľ��
			for (int k = 0; k < a.length; k++) {
				System.out.print(" " + a[k]); // ���
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		int[] shuzu = { 9, 45, 23, 14, 67, 98, 3 }; // ��ʼ������
		int i;
		System.out.print("����ǰ������Ϊ��\n"); // �������ǰ������
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " ");
		}
		System.out.print("\n");
		bubbleSort(shuzu); // �������
		System.out.print("����������Ϊ��\n");
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " "); // �������������
		}
		System.out.print("\n");

	}

}
