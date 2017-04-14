package com.baobaotao.study.array;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GobangTwo {
	// 下面三个位图分别代表棋盘、黑子、白子
		BufferedImage table;
		BufferedImage black;
		BufferedImage white;
		// 当鼠标移动时候的选择框
		BufferedImage selected;
		// 定义棋盘的大小
		private static int BOARD_SIZE = 15;
		// 定义棋盘宽、高多少个像素
		private final int TABLE_WIDTH = 535;
		private final int TABLE_HETGHT = 536;
		// 定义棋盘坐标的像素值和棋盘数组之间的比率。
		private final int RATE = TABLE_WIDTH / BOARD_SIZE;
		// 定义棋盘坐标的像素值和棋盘数组之间的偏移距。
		private final int X_OFFSET = 5;
		private final int Y_OFFSET = 6;
		// 定义一个二维数组来充当棋盘
		private String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
		// 五子棋游戏的窗口
		JFrame f = new JFrame("五子棋游戏");
		// 五子棋游戏棋盘对应的Canvas组件
		ChessBoard chessBoard = new ChessBoard();
		// 当前选中点的坐标
		private int selectedX = -1;
		private int selectedY = -1;
		//是否游戏结束
		private boolean isEnd=false;
		public void init()throws Exception
		{
			table = ImageIO.read(new File("H:/crazyJava/codes/11/11.8/image/board.jpg"));
			black = ImageIO.read(new File("H:/crazyJava/codes/11/11.8/image/black.gif"));
			white = ImageIO.read(new File("H:/crazyJava/codes/11/11.8/image/white.gif"));
			selected = ImageIO.read(new File("H:/crazyJava/codes/11/11.8/image/selected.gif"));
			// 把每个元素赋为"╋"，"╋"代表没有棋子
			for (int i = 0 ; i < BOARD_SIZE ; i++)
			{
				for ( int j = 0 ; j < BOARD_SIZE ; j++)
				{
					board[i][j] = "╋";
				}
			}
			chessBoard.setPreferredSize(new Dimension(
				TABLE_WIDTH , TABLE_HETGHT));
			chessBoard.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					// 将用户鼠标事件的坐标转换成棋子数组的坐标。
					int xPos = (int)((e.getX() - X_OFFSET) / RATE);
					int yPos = (int)((e.getY() - Y_OFFSET ) / RATE);
					board[xPos][yPos] = "●";
					System.out.println(xPos+"|"+yPos);
					//如果是赢了 或者是满了，，应该输出相应的画面不用进行下面的了
					if(isFull(board)||isWin(new int[]{xPos,yPos})){
						//应该输出游戏结束
						//这个地方需要做个判断，如果满了就不计算了
						isEnd=true;
						chessBoard.repaint();
						return;
					}
					/*
					电脑随机生成两个整数，作为电脑下棋的坐标，赋给board数组。
					还涉及:
					1.如果下棋的点已经有棋子，不能重复下棋。
					2.每次下棋后，需要扫描谁赢了
					*/
					int[] pointXY=getUnUsedPoinst(board);
					board[pointXY[0]][pointXY[1]] = "○";
					if(isFull(board)||isWin(pointXY)){
						//应该输出游戏结束
						//这个地方需要做个判断，如果满了就不计算了
						isEnd=true;
						chessBoard.repaint();
						return;
					}
					//
					chessBoard.repaint();
				}
				
				// 当鼠标退出棋盘区后，复位选中点坐标
				public void mouseExited(MouseEvent e)
				{
					selectedX = -1;
					selectedY = -1;
					chessBoard.repaint();
				}
			});
			chessBoard.addMouseMotionListener(new MouseMotionAdapter()
			{
				// 当鼠标移动时，改变选中点的坐标
				public void mouseMoved(MouseEvent e)
				{
					selectedX = (e.getX() - X_OFFSET) / RATE;
					selectedY = (e.getY() - Y_OFFSET) / RATE;
					chessBoard.repaint();
				}
			});
			f.add(chessBoard);
			f.pack();
			f.setVisible(true);
		}
		private int[] getUnUsedPoinst(String[][] board) {
			Random random=new Random();
			int x=random.nextInt(board.length-1);
			int y=random.nextInt(board.length-1);
			while(!"╋".equals(board[x][y])){
				x=random.nextInt(board.length-1);
				y=random.nextInt(board.length-1);
			}
			return new int[]{x,y};
		}
		/**
		 * 判断是否棋盘满了
		 * @param board
		 * @return
		 */
		public boolean isFull(String[][] board){
			for(int i=0;i<board.length;i++){
				for(int j=0;j<board[i].length;j++){
					if("╋".equals(board[i][j])){
						return false;
					}
				}
			}
			return true;
		}
		/**
		 * 判断是否赢了
		 * 从下棋点 横。竖  斜线 进行判断是否赢了。
		 * @param board
		 * @return
		 */
		public boolean isWin(int[] point){
			int[][][] dir=new int[][][]{{{1,0},{-1,0}},{{0,1},{0,-1}},{{-1,-1},{1,1}},{{-1,1},{1,-1}}};
			for(int i=0;i<dir.length;i++){
				int linkCount=1;
				for(int j=0;j<dir[i].length;j++){
					int temX=point[0];
					int temY=point[1];
					while(true){
						temX+=dir[i][j][0];
						temY+=dir[i][j][1];
						if(temX>=board.length||temY>=board.length||temX<0||temY<0) break;
						if(!board[temX][temY].equals(board[point[0]][point[1]])) break;
						linkCount++;
						if(linkCount>=5) return true;
					}
				}
				if(linkCount>=5) return true;
			}
			return false;
		}
		public static void main(String[] args) throws Exception
		{
			GobangTwo gb = new GobangTwo();
			gb.init();
			
		}
		class ChessBoard extends JPanel
		{
			// 重写JPanel的paint方法，实现绘画
			public void paint(Graphics g)
			{
				// 将绘制五子棋棋盘
				g.drawImage(table , 0 , 0 , null);
				// 绘制选中点的红框
				if (selectedX >= 0 && selectedY >= 0)
					g.drawImage(selected , selectedX * RATE + X_OFFSET ,
				selectedY * RATE + Y_OFFSET, null);
				// 遍历数组，绘制棋子。
				for (int i = 0 ; i < BOARD_SIZE ; i++)
				{
					for ( int j = 0 ; j < BOARD_SIZE ; j++)
					{
						// 绘制黑棋
						if (board[i][j].equals("●"))
						{
							g.drawImage(black , i * RATE + X_OFFSET
								, j * RATE + Y_OFFSET, null);
						}
						// 绘制白棋
						if (board[i][j].equals("○"))
						{
							g.drawImage(white, i * RATE  + X_OFFSET
								, j * RATE  + Y_OFFSET, null);
						}
					}
				}
				if(isEnd){
					g.setColor(new Color(255,0,0));
					g.setFont(new Font("Times",Font.BOLD,30));
					g.drawString("游戏结束！！！",50,200);
				}
			}
		}
}
