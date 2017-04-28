package com.baobaotao.study.designmodel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Console {
	JFrame jf=new JFrame("商城结算系统");
	//
	JPanel jpl=new JPanel(new GridLayout(3, 3));
	//第一行
	
	JLabel lablePrice=new JLabel("单价:");
	JTextField jtfPrice=new JTextField(10);
	JButton trueBtn=new JButton("确定:");
	JLabel lableNumber=new JLabel("数量:");
	JTextField jtfNumber=new JTextField(10);
	JButton resetBtn=new JButton("重置");
	//第二行
	
	JTextArea jta=new JTextArea(5, 25);
	//第三行
	JLabel discountLabel=new JLabel("计算方式");
	String[] items={"二折","三折","四折","八折"};
	JComboBox<String> list=new JComboBox<>(items);
	//最后一行
	JLabel totalLable=new JLabel("总计");
	//
	private double total;
	public void init(){
		trueBtn.addActionListener(e->{
			double price=Double.parseDouble(jtfPrice.getText());
			double num=Double.parseDouble(jtfNumber.getText());
			Operator op=Operator.getOperator(list.getSelectedItem().toString());
			total+=op.operate(num*price);
			jta.append(price+"*"+num+"="+price*num+"\r\n");
			totalLable.setText("总计:"+total);
		});
		//
		jpl.add(lablePrice);
		jpl.add(jtfPrice);
		jpl.add(trueBtn);
		jpl.add(lableNumber);
		jpl.add(jtfNumber);
		jpl.add(resetBtn);
		jpl.add(discountLabel);
		jpl.add(list);
		jf.add(jpl,BorderLayout.NORTH);
		jf.add(new JScrollPane(jta));
		jf.add(totalLable,BorderLayout.SOUTH);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args){
		//new Console().init();
		Scanner scanner=new Scanner(System.in);
	}
}
