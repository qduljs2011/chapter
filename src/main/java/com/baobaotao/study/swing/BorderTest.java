package com.baobaotao.study.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class BorderTest {
	private JFrame jf=new JFrame("测试边框");
	public void init(){
		jf.setLayout(new GridLayout(2, 4));
		//使用静态工厂方法创建bevelBorder
		Border bb=BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED,Color.GREEN,Color.BLUE,Color.GRAY);
		jf.add(getPanelWithBorder(bb, "BevelBorder"));
		//使用静态工厂方法创建LIneborder
		Border lb=BorderFactory.createLineBorder(Color.ORANGE,10);
		jf.add(getPanelWithBorder(lb, "LineBorder"));
		//使用静态工厂方法创建EmptyBorder，组件四周留空
		Border eb=BorderFactory.createEmptyBorder(20,5,10,30);
		jf.add(getPanelWithBorder(eb, "EmptyBorder"));
		//使用静态工厂方法创建etcheBorder
		Border etb=BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.RED,Color.GREEN);
		jf.add(getPanelWithBorder(etb, "EmptyBorder"));
		//直接创建Titleborder，TitleBorder就是为原有的边框增加标题
		TitledBorder tb=new TitledBorder(lb,"测试标题",TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("StSong",Font.BOLD,18),Color.BLUE);
		jf.add(getPanelWithBorder(tb, "TitledBorder"));
		//直接创建MatteBorder(),MatteBorder 是 EmptyBorder的子类
		//它可以指定留空区域的颜色或北京，此处指定颜色
		MatteBorder mb=new MatteBorder(20,4,10,30,Color.GREEN);
		jf.add(getPanelWithBorder(mb,"MatteBorder"));
		//直接创建CompoundBorder,CompoundBorder将两个边框组合成新边框
		CompoundBorder cb=new CompoundBorder(new LineBorder(Color.RED,8),tb);
		jf.add(getPanelWithBorder(cb,"CompoundBorder"));
		jf.pack();
		jf.setVisible(true);
		
	}
	public static void main(String[] args) {
		new BorderTest().init();
	}
	public JPanel getPanelWithBorder(Border b,String BorderName){
		JPanel p=new JPanel();
		p.add(new JLabel(BorderName));
		//为Panel组件设置边框
		p.setBorder(b);
		return p;
	}
}
