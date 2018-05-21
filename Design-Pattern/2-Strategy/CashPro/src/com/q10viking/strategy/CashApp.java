package com.q10viking.strategy;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
public class CashApp extends JFrame{

	private static double total = 0.0d;
	private JTextArea displayArea;
	private JTextField priceText,numText;
	private CashJComboBox cb;
	private StringBuilder msgBuffer = new StringBuilder();
	public CashApp() {
		super("Q10-CashApp");
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(280,350);
		setLocationRelativeTo(null);
	//	setResizable(false);
		setVisible(true);
	}
	
	private void initComponents() {
		Font f = new Font("宋体",Font.PLAIN,14);
		JLabel priceLabel = new JLabel("单价：   ");
		priceLabel.setFont(f);
		JLabel numLabel = new JLabel("数量：   ");
		numLabel.setFont(f);
		priceText = new JTextField("",6);
		priceText.setFont(f);
		numText = new JTextField("",6);
		numText.setFont(f);
		JButton sureButton = new JButton("确认");
		sureButton.setFont(f);
		JButton resetButton = new JButton("重置");
		resetButton.setFont(f);
		cb = new CashJComboBox();
		
		displayArea = new JTextArea(" ",10,22);		
	
		setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		add(priceLabel);
		add(priceText);
		add(sureButton);
		sureButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					System.out.println("Click 确认");
					//获取下拉框内容
					String option = cb.getSelectedItems();
					//System.out.println(option);
					//获取策略对象
					CashContext context = new CashContext(option);
					//数量
					double num = Double.parseDouble(numText.getText());
					double price = Double.parseDouble(priceText.getText());
					double money = num*price;
					double accepted = context.GetResult(money);
					String items = "单价: "+price+" 数量： "+num+" "+option+" 合计:"+accepted+"\n";
					//String items = String.format("%s %-5.1f %s %-5.1f %s   %s %.1f\n","单价:",price,"数量：",num,option,"合计: ",accepted);
			
					msgBuffer.append(items);
					//System.out.println(msgBuffer);
					displayArea.setText(msgBuffer.toString());
			}
			
		});
		
		add(numLabel);
		add(numText);
		add(resetButton);
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Click 重置");
				displayArea.setText("");
				numText.setText("");
				priceText.setText("");
				//清空缓存
				msgBuffer.setLength(0);;
			}
			
		});
		
		add(cb);
		add(displayArea);
		
	}
	public static void main(String[] args) {
		
		new CashApp();
		
		
		
		String option = "打8折";
		CashContext csuper = new CashContext(option);
		double totalPrices = 0d;
		totalPrices = csuper.GetResult(80*5);
		total = total + totalPrices;
		System.out.println("单价：  "+80+" 数量： "+5+" "+option+" 合计： "+totalPrices);
		System.out.println("总价： "+total);
	}

}
