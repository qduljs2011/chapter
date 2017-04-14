package com.baobaotao.study.awt;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageIoStudy {
	private final int  WIDTH=100;
	private final int  HEIGHT=80;
	private BufferedImage image=new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	Graphics graphics=image.getGraphics();
	public void doom() throws IOException{
		
		Image srcImage=ImageIO.read(new File("C:/Users/Public/Pictures/Sample Pictures/3.jpg"));
		
		graphics.drawImage(srcImage, 0, 0,WIDTH,HEIGHT, null);
		ImageIO.write(image, "jpeg", new FileOutputStream("C:/Users/DELL/Desktop/123.jpg"));
	}
	public static void main(String[] args) throws IOException {
		
		new ImageIoStudy().doom();
	}
}
