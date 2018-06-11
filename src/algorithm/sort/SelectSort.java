package algorithm.sort;

/**
 * ѡ������
 *
 */
public class SelectSort {

	public static void selectSort(int[] a) {
		int index, temp;
		for (int i = 0; i < a.length - 1; i++) {
			index = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[index]) {
					index = j;
				}
			}
			// ����������
			if (index != i) {
				temp = a[i];
				a[i] = a[index];
				a[index] = temp;
			}
			System.out.print("��" + i + "��������:"); // ���ÿ������Ľ��
			for (int h = 0; h < a.length; h++) {
				System.out.print(" " + a[h]); // ���
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
		selectSort(shuzu); // �������
		System.out.print("����������Ϊ��\n");
		for (i = 0; i < shuzu.length; i++) {
			System.out.print(shuzu[i] + " "); // �������������
		}
		System.out.print("\n");
	}

}
