package algorithm.struct;

/**
 * 
 * ˳���
 *
 */
class SLType {
	static final int MAXLEN = 100;
	DATA[] ListData = new DATA[MAXLEN + 1]; // ����˳���Ľṹ����
	int ListLen; // ˳����Ѵ��������

	void SLInit(SLType SL) // ��ʼ��˳���
	{
		SL.ListLen = 0; // ��ʼ��Ϊ�ձ�
	}

	int SLLength(SLType SL) {
		return (SL.ListLen); // ����˳����Ԫ������
	}

	int SLInsert(SLType SL, int n, DATA data) {
		int i;
		if (SL.ListLen >= MAXLEN) // ˳����������ѳ����������
		{
			System.out.print("˳������������ܲ�����!\n");
			return 0; // ����0��ʾ���벻�ɹ�
		}
		if (n < 1 || n > SL.ListLen - 1) // ��������Ų���ȷ
		{
			System.out.print("����Ԫ����Ŵ��󣬲��ܲ���Ԫ�أ�\n");
			return 0; // ����0����ʾ���벻�ɹ�
		}
		for (i = SL.ListLen; i >= n; i--) // ��˳����е���������ƶ�
		{
			SL.ListData[i + 1] = SL.ListData[i];
		}
		SL.ListData[n] = data; // ������
		SL.ListLen++; // ˳�������������1
		return 1; // �ɹ����룬����1
	}

	int SLAdd(SLType SL, DATA data) // ����Ԫ�ص�˳���β��
	{
		if (SL.ListLen >= MAXLEN) // ˳�������
		{
			System.out.print("˳�����������������ӽ���ˣ�\n");
			return 0;
		}
		SL.ListData[++SL.ListLen] = data;
		return 1;
	}

	int SLDelete(SLType SL, int n) // ɾ��˳����е�����Ԫ��
	{
		int i;
		if (n < 1 || n > SL.ListLen + 1) // ɾ�������Ų���ȷ
		{
			System.out.print("ɾ�������Ŵ��󣬲���ɾ����㣡\n");
			return 0; // ɾ�����ɹ�������0
		}
		for (i = n; i < SL.ListLen; i++) // ��˳����е�������ǰ�ƶ�
		{
			SL.ListData[i] = SL.ListData[i + 1];
		}
		SL.ListLen--; // ˳���Ԫ��������1
		return 1; // �ɹ�ɾ��������1
	}

	DATA SLFindByNum(SLType SL, int n) // ������ŷ�������Ԫ��
	{
		if (n < 1 || n > SL.ListLen + 1) // Ԫ����Ų���ȷ
		{
			System.out.print("�����Ŵ��󣬲��ܷ��ؽ�㣡\n");
			return null; // ���ɹ����򷵻�0
		}
		return SL.ListData[n];
	}

	int SLFindByCont(SLType SL, String key) // ���ؼ��ֲ�ѯ���
	{
		int i;
		for (i = 1; i <= SL.ListLen; i++) {
			if (SL.ListData[i].key.compareTo(key) == 0) // ����ҵ�������
			{
				return i; // ���ؽ�����
			}
		}
		return 0; // �������������û���ҵ����򷵻�0
	}

	int SLAll(SLType SL) // ��ʾ˳����е����н��
	{
		int i;
		for (i = 1; i <= SL.ListLen; i++) {
			System.out.printf("(%s,%s,%d)\n", SL.ListData[i].key,
					SL.ListData[i].name, SL.ListData[i].age);
		}
		return 0;
	}
}

public class SLTypeTest {
	public static void main(String[] args) {

		SLType SL = new SLType(); // ����˳������
		// DATA data=new DATA(); //�����㱣���������ͱ���
		DATA pdata; // �����㱣��ָ�����

		System.out.print("˳��������ʾ!\n");

		SL.SLInit(SL); // ��ʼ��˳���

		DATA data = new DATA("0001", "linj", 34);
		SL.SLAdd(SL, data);
		data = new DATA("0002", "lisi", 24);
		SL.SLAdd(SL, data);
		data = new DATA("0003", "zsi", 14);
		SL.SLAdd(SL, data);

		SL.SLAll(SL); // ��ʾ���н������

		System.out.print("\nҪȡ��������ţ�");

		pdata = SL.SLFindByNum(SL, 2); // ����Ų��ҽ��
		if (pdata != null) // �����صĽ��ָ�벻ΪNULL
		{
			System.out.printf("��%d�����Ϊ��(%s,%s,%d)\n", 2, pdata.key, pdata.name,
					pdata.age);
		}

		System.out.print("\nҪ���ҽ��Ĺؼ��֣�");
		// ����ؼ���
		int i = SL.SLFindByCont(SL, "0003"); // ���ؼ��ֲ��� �����ؽ�����
		if (pdata != null) // �����ָ�벻ΪNULL
		{
			System.out.printf("��%d�����Ϊ��(%s,%s,%d)\n", i, pdata.key, pdata.name,
					pdata.age);
		}
	}

}
