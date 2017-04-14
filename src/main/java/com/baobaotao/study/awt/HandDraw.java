package com.baobaotao.study.awt;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

public class HandDraw {
	private final int  AREA_WIDTH=500;
	private final int  AREA_HEIGHT=400;
	private int pre_x=-1;
	private int pre_y=-1;
	private Frame frame=new Frame("划线");
	private BufferedImage image=new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
	private Color forColor=new Color(255,0,0);
	private Graphics graphics=image.getGraphics();
	private MyCanvas drawArea=new MyCanvas();
	public void init(){
		ActionListener al=e->{
			if("red".equals(e.getActionCommand())){
				forColor=new Color(255,0,0);
			}else if("green".equals(e.getActionCommand())){
				forColor=new Color(0,255,0);
			}else if("blue".equals(e.getActionCommand())){
				forColor=new Color(0,0,255);
			}
		};
		MenuItem green=new MenuItem("green");
		MenuItem blue=new MenuItem("blue");
		MenuItem red=new MenuItem("red");
		green.addActionListener(al);
		blue.addActionListener(al);
		red.addActionListener(al);
		PopupMenu pop=new PopupMenu();
		pop.add(green);
		pop.add(blue);
		pop.add(red);
		drawArea.add(pop);
		graphics.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
		drawArea.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(pre_x>0&&pre_y>0){
					graphics.setColor(forColor);
					graphics.drawLine(pre_x, pre_y, e.getX(), e.getY());
				}
				pre_x=e.getX();
				pre_y=e.getY();
				drawArea.repaint();
			}
		});
		drawArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()){
					pop.show(drawArea, e.getX(), e.getY());
				}
				pre_x=-1;
				pre_y=-1;
			}
		});
		
		frame.add(drawArea);
		frame.pack();
		frame.setVisible(true);
	}
	class MyCanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, null);
		}
	}
	public static void main(String[] args) {
		new HandDraw().init();
	}
}
