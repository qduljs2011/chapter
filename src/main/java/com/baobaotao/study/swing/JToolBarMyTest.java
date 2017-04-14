package com.baobaotao.study.swing;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class JToolBarMyTest {
	private JFrame jf = new JFrame("工具条测试");
	private JTextArea jta = new JTextArea(5, 20);
	private JToolBar jtb = new JToolBar();
	Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
	JMenuBar jmb = new JMenuBar();
	JMenu edit = new JMenu("编辑");
	Action pastAction = new AbstractAction("粘贴", new ImageIcon("ico/paste.png")) {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (cb.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				String content = "";
				try {
					content = cb.getData(DataFlavor.stringFlavor).toString();
				} catch (UnsupportedFlavorException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jta.replaceRange(content, jta.getSelectionStart(), jta.getSelectionEnd());
			}
		}
	};
	Action copyAction = new AbstractAction("复制", new ImageIcon("ico/copy.png")) {
		@Override
		public void actionPerformed(ActionEvent e) {
			StringSelection ss = new StringSelection(jta.getSelectedText());
			cb.setContents(ss, null);
			if (cb.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				pastAction.setEnabled(true);
			}
		}
	};

	public void init() {
		// pastAction处于禁用状态
		pastAction.setEnabled(false);
		//

		jf.add(new JScrollPane(jta));
		JButton copyBtn = new JButton(copyAction);
		JButton pastBtn = new JButton(pastAction);
		JPanel jp = new JPanel();
		jp.add(copyBtn);
		jp.add(pastBtn);
		jf.add(jp, BorderLayout.SOUTH);
		// 添加工具条
		jtb.add(copyAction);
		jtb.addSeparator();
		jtb.add(pastAction);
		// 向菜单中添加Action对象，该对象将会转换成菜单项
		edit.add(copyAction);
		edit.add(pastAction);
		// 将edit菜单添加到菜单条中
		jmb.add(edit);
		jf.setJMenuBar(jmb);
		// 设置工具条和工具按钮之间的页边距。
		jtb.setMargin(new Insets(20, 10, 5, 30)); // ②
		// 向窗口中添加工具条
		jf.add(jtb, BorderLayout.NORTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new JToolBarMyTest().init();
	}
}
