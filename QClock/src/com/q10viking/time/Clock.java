package com.q10viking.time;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock extends JComponent{
	private Font f = new Font("宋体",Font.PLAIN,15);
	private Font f2 = new Font("宋体",Font.BOLD,15);
	private JLabel labelTime = new JLabel("当前时间");
	private JLabel display = new JLabel();
	private JLabel display2 = new JLabel();
	
	private LocalDateTime now = LocalDateTime.now();
	private int hour = 0;
	private int min = 0;
	private int sec = 0;
	
	private Graphics2D g;
	final double PI = Math.PI;
	private String strTime = "";
	
	
	public Clock() {
		
		add(labelTime);
		labelTime.setFont(f);
		labelTime.setBounds(120,320,80,20);
		
		add(display);
		display.setBounds(190,320,80,20);
		display.setFont(f);
		display.setBorder(BorderFactory.createLineBorder(Color.black));
		
		add(display2);
		display2.setBounds(110,350,250,20);
		display2.setFont(f);
		hour = now.getHour();
		min = now.getMinute();
		sec = now.getSecond();
		setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g1) {
		double x,y;
		super.paintComponent(g1);
		g = (Graphics2D) g1;
		//锯齿开关
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//表盘
		//设置渐变颜色

		g.setPaint(new GradientPaint(5,40,Color.GREEN,15,50,Color.blue,true));
		//设置画笔的行迹
		g.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND));
		
		g.drawOval(75, 40, 250, 250);
		g.fillOval(195, 160, 10, 10);
		g.setColor(Color.black);
		//画60个点
		for(int i=0;i<60;i++) {
			double[] co = new double[2];
			double angle = PI*1.5+i*2*PI/60;
			co = paint_Dot(angle);
			x = co[0];y=co[1];
			if(i == 0 || i == 15 || i== 30 || i == 45) {
				g.fillOval((int)(x-5+201), (int)(y-5+168), 10, 10);
			}else {
				//其他小点
				g.fillOval((int)(x-2.5+201), (int)(y-5+168),5,5);
			}
			if(i%5 == 0 && i!=0 && i!=15 && i!=30 && i!=45) {
				x = 105*Math.cos(angle);
				y = 105*Math.sin(angle);
				g.drawString(i/5+"",(int)(x+197),(int)(y+167));
			}
		}
		
		//画四个数字
		g.setFont(f2);
		g.drawString("3",300,175);
		g.drawString("6", 195, 273);
		g.drawString("9",91,171);
		g.drawString("12", 190, 68);
		
		//画时钟
		paint_HourPointer(hour*3600+min*60+sec,g);
		//画分针
		paint_MinutePointer(min*60+sec,g);
		//画秒针
		paint_SecondPointer(sec);
	}
	public void paint_HourPointer(int second,Graphics2D g) {
		double x,y,angle;
		angle = second*PI/21600;  //时针的速度PI/60*60*60(rad/s)
		x = 200+60*Math.sin(angle);
		y = 165-60*Math.cos(angle);
		g.setStroke( new BasicStroke(5,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND));
		g.setPaint(new GradientPaint(200,165,Color.red,260,165,Color.blue,true));
		g.drawLine(200, 165, (int)x, (int)y);
	}
	
	public void paint_MinutePointer(int second,Graphics2D g) {
		double x,y,angle;
		angle = second*PI/1800;
		x = 200+80*Math.sin(angle);
		y = 165-80*Math.cos(angle);
		g.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND));
		g.setPaint(new GradientPaint(200,165,Color.magenta,280,165,Color.blue,true));
		g.drawLine(200, 165, (int)x, (int)y);
	}
	
	public void paint_SecondPointer(int second) {
		double x,y,angle,x1,y1;
		angle = second*PI/30;   //(PI*2/60)
		x = 200+95*Math.sin(angle);
		y = 165-95*Math.cos(angle);
		g.setStroke( new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g.setPaint(new GradientPaint(180,165,Color.CYAN,295,165,Color.MAGENTA,true));
		x1 = 200+20*Math.sin(angle+PI);
		y1 = 165-20*Math.cos(angle+PI);
		
		g.drawLine((int)x1, (int)y1, (int)x, (int)y);
		
	}
	public void showUI() {
		new Thread() {
			public void run() {
				while(true) {
					showTime();
					now = LocalDateTime.now();
					hour = now.getHour();
					min = now.getMinute();
					sec = now.getSecond();
					try {
						Thread.sleep(1000);
					}catch(InterruptedException ex) {
						ex.printStackTrace();
					}
					repaint();
				} 
			}
		}.start();	
	}
	public void showTime() {
		//时间
		String time = GetDateTimeUtil.getTime();
		display.setText(time);
		//日期
		String dateTime = GetDateTimeUtil.getDateTime();
		display2.setText(dateTime);
	}
	
	public double[] paint_Dot(double angle) {
		double[] co = new double[2];
		co[0] = 115*Math.cos(angle);
		co[1] = 115*Math.sin(angle);
		return co;
	}
	
	public static void main(String[] args) {
		Clock clock = new Clock();
		clock.showUI();
		JFrame f = new JFrame("Clock by Q10Viking");
		f.setSize(400, 400);
		f.add(clock,BorderLayout.CENTER);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
	}
}





















