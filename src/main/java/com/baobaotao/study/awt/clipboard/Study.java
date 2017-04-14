package com.baobaotao.study.awt.clipboard;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.Box;

public class Study {
	public void test1(){
		//创建系统粘贴板
		Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
		Frame frame=new Frame("clipboard");
		TextArea src=new TextArea(5,20);
		TextArea dest=new TextArea(5,20);
		Panel panel=new Panel();
		Button copy=new Button("copy");
		Button past=new Button("past");
		Box box=Box.createHorizontalBox();
		box.add(src);
		box.add(dest);
		copy.addActionListener(e->{
			StringSelection msg=new StringSelection(src.getText());
			clipboard.setContents(msg, null);
		});
		past.addActionListener(e->{
			if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
				try {
					dest.setText(clipboard.getData(DataFlavor.stringFlavor).toString());
				} catch (UnsupportedFlavorException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(copy);
		panel.add(past);
		frame.add(box);
		frame.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Study().test1();
	}
}
