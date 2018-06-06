/**
 * Java Swing ֮�����б�ؼ�
 * @author gao
 */
package com.gao;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JComboBoxDemo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JComboBoxDemo() {
		this.setTitle("�����б��ʹ��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 250, 100);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel label = new JLabel("֤������:");
		contentPane.add(label);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("���֤");
		comboBox.addItem("��ʻ֤");
		comboBox.addItem("����֤");
		contentPane.add(comboBox);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		JComboBoxDemo example = new JComboBoxDemo();
	}
}