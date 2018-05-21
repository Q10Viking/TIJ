package com.q10viking.strategy;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//维护一个JComboBox组件
public class CashJComboBox extends JComponent {
	private String[] cashActivities = new String[] {
			"正常收费",
			"满300返100",
			"打8折",	
	};
	private JComboBox<String> cb;
	public CashJComboBox(){
		cb = new JComboBox<String>(cashActivities);
		setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		cb.setFont(new Font("宋体",Font.PLAIN,14));
		add(cb);
	}
	
	public String getSelectedItems() {
		return (String)cb.getSelectedItem();
	}
	//测试组件
	public static void main(String[] args) {
		JFrame f = new JFrame("Test");
		f.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		f.add(new CashJComboBox());
		f.add(new JTextField("JTextField",8));
		f.add(new JTextArea("JTextArea",10,20));
		f.setSize(260,280);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setLocationRelativeTo(null);
		
		f.setVisible(true);
	}
}
