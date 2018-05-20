package com.q10viking.time;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Clock clock = new Clock();
		clock.showUI();
		JFrame f = new JFrame("Clock by Q10Viking");
		
		//获取屏幕宽度
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		final int WIDTH = screenSize.width;
		final int HEIGHT = screenSize.height;
		System.out.println(WIDTH+" "+HEIGHT);
		

		f.setSize(400, 400);
		f.add(clock,BorderLayout.CENTER);
		//去掉边框
		f.setUndecorated(true);
		//设置透明度整体
		//f.setOpacity(0.5f);
		//设置背景透明
		f.setBackground(new Color(0, 0, 0, 0));
		//设置图标
		Image img = new ImageIcon(f.getClass().getResource("/clock.png")).getImage();
		 f.setIconImage(img);
		f.setVisible(true);
		f.setResizable(false);
		//设置居中
	//	f.setLocationRelativeTo(null);
		//自定义位置
		f.setLocation(WIDTH/2-WIDTH/8,-20);

	}

}
