package algorithm.struct;

import java.util.Scanner;

/**
 * 
 * 链表结构
 *
 */
class CLType // 定义链表结构
{
	DATA nodeData = new DATA();
	CLType nextNode;

	@SuppressWarnings("unused")
	CLType CLAddEnd(CLType head, DATA nodeData) // 追加结点
	{
		CLType node, htemp;
		if ((node = new CLType()) == null) {
			System.out.print("申请内存失败！\n");
			return null; // 分配内存失败
		} else {
			node.nodeData = nodeData; // 保存数据
			node.nextNode = null; // 设置结点指针为空，即为表尾
			if (head == null) // 头指针
			{
				head = node;
				return head;
			}
			htemp = head;
			while (htemp.nextNode != null) // 查找链表的末尾
			{
				htemp = htemp.nextNode;
			}
			htemp.nextNode = node;
			return head;
		}
	}

	@SuppressWarnings("unused")
	CLType CLAddFirst(CLType head, DATA nodeData) {
		CLType node;
		if ((node = new CLType()) == null) {
			System.out.print("申请内存失败！\n");
			return null; // 分配内存失败
		} else {
			node.nodeData = nodeData; // 保存数据
			node.nextNode = head; // 指向头指针所指结点
			head = node; // 头指针指向新增结点
			return head;
		}
	}

	CLType CLFindNode(CLType head, String key) // 查找结点
	{
		CLType htemp;
		htemp = head; // 保存链表头指针
		while (htemp != null) // 若结点有效，则进行查找
		{
			if (htemp.nodeData.key.compareTo(key) == 0) // 若结点关键字与传入关键字相同
			{
				return htemp; // 返回该结点指针
			}
			htemp = htemp.nextNode; // 处理下一结点
		}
		return null; // 返回空指针
	}

	@SuppressWarnings("unused")
	CLType CLInsertNode(CLType head, String findkey, DATA nodeData) // 插入结点
	{
		CLType node, nodetemp;
		if ((node = new CLType()) == null) // 分配保存结点的内容
		{
			System.out.print("申请内存失败！\n");
			return null; // 分配内存失败
		}
		node.nodeData = nodeData; // 保存结点中的数据
		nodetemp = CLFindNode(head, findkey);
		if (nodetemp != null) // 若找到要插入的结点
		{
			node.nextNode = nodetemp.nextNode; // 新插入结点指向关键结点的下一结点
			nodetemp.nextNode = node; // 设置关键结点指向新插入结点
		} else {
			System.out.print("未找到正确的插入位置！\n");
			// free(node); //释放内存
		}
		return head; // 返回头指针
	}

	int CLDeleteNode(CLType head, String key) {
		CLType node, htemp; // node保存删除结点的前一结点
		htemp = head;
		node = head;
		while (htemp != null) {
			if (htemp.nodeData.key.compareTo(key) == 0) // 找到关键字，执行删除操作
			{
				node.nextNode = htemp.nextNode; // 使前一结点指向当前结点的下一结点
				// free(htemp); //释放内存
				return 1;
			} else {
				node = htemp; // 指向当前结点
				htemp = htemp.nextNode; // 指向下一结点
			}
		}
		return 0; // 未删除
	}

	int CLLength(CLType head) // 计算链表长度
	{
		CLType htemp;
		int Len = 0;
		htemp = head;
		while (htemp != null) // 遍历整个链表
		{
			Len++; // 累加结点数量
			htemp = htemp.nextNode; // 处理下一结点
		}
		return Len; // 返回结点数量
	}

	void CLAllNode(CLType head) // 遍历链表
	{
		CLType htemp;
		DATA nodeData;
		htemp = head;
		System.out.printf("当前链表共有%d个结点。链表所有数据如下：\n", CLLength(head));
		while (htemp != null) // 循环处理链表每个结点
		{
			nodeData = htemp.nodeData; // 获取结点数据
			System.out.printf("结点(%s,%s,%d)\n", nodeData.key, nodeData.name,
					nodeData.age);
			htemp = htemp.nextNode; // 处理下一结点
		}
	}

}

public class CLTypeTest {

	private static Scanner input;

	public static void main(String[] args) {
		CLType node, head = null;
		CLType CL = new CLType();
		String key;
		input = new Scanner(System.in);

		System.out.print("链表测试。先输入链表中的数据，格式为：关键字 姓名 年龄\n");

		DATA nodeData = new DATA();
		nodeData.key = "0001";
		nodeData.name = "my";
		nodeData.age = 34;
		head = CL.CLAddEnd(head, nodeData);// 在链表尾部添加结点
		nodeData = new DATA();
		nodeData.key = "0002";
		nodeData.name = "my2";
		nodeData.age = 4;
		head = CL.CLAddEnd(head, nodeData);// 在链表尾部添加结点
		nodeData = new DATA();
		nodeData.key = "0003";
		nodeData.name = "my3";
		nodeData.age = 3;
		head = CL.CLAddEnd(head, nodeData);// 在链表尾部添加结点

		CL.CLAllNode(head); // 显示所有结点

		System.out.printf("\n演示插入结点，输入插入位置的关键字：");
		nodeData = new DATA();
		nodeData.key = "0005";
		nodeData.name = "you";
		nodeData.age = 15;// 输入插入结点数据
		head = CL.CLInsertNode(head, "0002", nodeData); // 调用插入函数
		CL.CLAllNode(head); // 显示所有结点

		System.out.print("\n演示删除结点，输入要删除的关键字:");

		key = input.next(); // 输入删除结点关键字
		CL.CLDeleteNode(head, key); // 调用删除结点函数
		CL.CLAllNode(head); // 显示所有结点

		System.out.printf("\n演示在链表中查找，输入查找关键字:");
		key = input.next(); // 输入查找关键字
		node = CL.CLFindNode(head, key); // 调用查找函数，返回结点指针
		if (node != null) // 若返回结点指针有效
		{
			nodeData = node.nodeData; // 获取结点的数据
			System.out.printf("关键字%s对应的结点为(%s,%s,%d)\n", key, nodeData.key,
					nodeData.name, nodeData.age);
		} else // 若结点指针无效
		{
			System.out.printf("在链表中未找到关键字为%s的结点！\n", key);
		}

	}

}
