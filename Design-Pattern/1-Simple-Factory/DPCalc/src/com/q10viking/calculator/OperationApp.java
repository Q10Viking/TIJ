package com.q10viking.calculator;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OperationApp extends JFrame{
	private JTextField numberAText;
	private JTextField numberBText;
	private JLabel result;
	private JButton calc;
	private JComboBox<Character> operationsCombo;
	Operation oper;
	OperationApp(){
		super("Q10Viking-Calc");
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(150,210);
	}
	private void initComponents() {
		//维护基本的运算
		Character[] operationsArray = new Character[]{
				'+',
				'-',
				'*',
				'/'
		};
		Font font = new Font("宋体",Font.BOLD,20);
		operationsCombo =  new JComboBox<Character>(operationsArray);
		
		numberAText = new JTextField(8);
		numberBText = new JTextField(8);
		calc = new JButton("计算");
		calc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				char c = (Character)operationsCombo.getSelectedItem();
				oper = OperationFactory.createOperate(c);
				float number_one = Float.parseFloat(numberAText.getText());
				float number_two = Float.parseFloat(numberBText.getText());
				oper.setA(number_one);oper.setB(number_two);
				String re = oper.GetResult()+"";
				result.setText(re);
			}
			
		});
		
		
		JLabel resultLabel = new JLabel("计算结果： ");
		result =  new JLabel("                  ");
		result.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//加入布局
		setLayout(new FlowLayout());
		add(numberAText);
		add(operationsCombo);
		add(numberBText);
		add(calc);
		add(resultLabel);
		add(result);
	}
	
	public static void main(String[] args) {
		OperationApp op = new OperationApp();
		op.setVisible(true);
		
	}

}
