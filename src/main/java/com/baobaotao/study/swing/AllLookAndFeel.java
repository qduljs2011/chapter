package com.baobaotao.study.swing;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class AllLookAndFeel {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("test.txt");
		fos.write("abc".getBytes());
		fos.flush();
		fos.close();
		
	}
}
