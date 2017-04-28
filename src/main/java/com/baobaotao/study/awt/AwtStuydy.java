package com.baobaotao.study.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;


public class AwtStuydy {
	public void test1(){
		Frame frame=new Frame("测试窗口");
		Box box=Box.createHorizontalBox();
		Box box2=Box.createVerticalBox();
		box.add(new Button("button 1"));
		box.add(Box.createHorizontalGlue());
		box.add(new Button("button 2"));
		box.add(Box.createHorizontalStrut(10));
		box.add(new Button("button 3"));
		
		box2.add(new Button("button4"));
		box2.add(Box.createVerticalGlue());
		box2.add(new Button("button5"));
		box2.add(Box.createVerticalStrut(10));
		box2.add(new Button("button6"));
		
		frame.add(box, BorderLayout.SOUTH);
		frame.add(box2);
		WindowAdapter e=new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		frame.addWindowListener(e);
		frame.pack();
		frame.setVisible(true);
	}
	public void test2(){
		Frame f=new Frame("框架窗口");
		Button ok=new Button("ok");
		CheckboxGroup cbg=new CheckboxGroup();
		Checkbox male=new Checkbox("男",cbg,true);
		Checkbox female=new Checkbox("女",cbg,false);
		
		Checkbox married=new Checkbox("是否已婚?",false);
		
		Choice colorChooser=new Choice();
		List colorList=new List(6,true);
		//定义一个5行 20 列的 多行文本域
		TextArea ta=new TextArea(5, 20);
		//定义个50列的单行文本域
		TextField name=new TextField(50);
		//进行初始化
		colorChooser.add("红色");
		colorChooser.add("绿色");
		colorChooser.add("蓝色");
		
		colorList.add("红色");
		colorList.add("绿色");
		colorList.add("蓝色");
		//创建一个装载了文本框、按钮的panel
		Panel bottom=new Panel();
		bottom.add(name);
	}
	public void test3(){
		Frame frame=new Frame("dialog");
		Dialog log1=new Dialog(frame,"对话框1",true);
		Button button=new Button("model dialog");
		button.addActionListener(e->{
			log1.setVisible(true);
		});
		frame.add(button);
		frame.setVisible(true);
	}
	public void test4(){
		Frame frame =new Frame("基础窗口");
		FileDialog load=new FileDialog(frame, "加载文件", FileDialog.LOAD);
		FileDialog save=new FileDialog(frame, "保存文件", FileDialog.SAVE);
		Button loadBt=new Button("load Bt");
		Button saveBt=new Button("save Bt");
		loadBt.addActionListener(e->{
			load.setVisible(true);
			System.out.println(load.getDirectory()+load.getFile());
		});
		saveBt.addActionListener(e->{
			save.setVisible(true);
			System.out.println(save.getDirectory()+save.getFile());
		});
		frame.add(loadBt);
		frame.add(saveBt, BorderLayout.SOUTH);
		frame.pack();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}
	public void test5(){
		Frame frame=new Frame("menu frame");
		MenuBar menbar=new MenuBar();
		Menu file=new Menu("file");
		Menu edit=new Menu("edit");
		
		MenuItem autoLine=new MenuItem("autoLine");
		MenuItem separator=new MenuItem("-");
		MenuItem copy=new MenuItem("copy");
		MenuItem past=new MenuItem("past");
		//
		Menu format=new Menu("format");
			//
			MenuItem commont=new MenuItem("commont", new MenuShortcut(KeyEvent.VK_A, true));
			MenuItem cancelCommon=new MenuItem("cancelCommon");
		format.add(commont);
		format.add(cancelCommon);
		edit.add(autoLine);
		edit.add(separator);
		edit.add(copy);
		edit.add(past);
		edit.add(format);
		//
		menbar.add(file);
		menbar.add(edit);
		//
		frame.setMenuBar(menbar);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		for(int i=0;i<12;i+=2){
			System.out.println(i);
		}
	}
}
