package com.baobaotao.study.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gobang {
	// 定义棋盘的大小
	private static int BOARD_SIZE = 15;
	// 定义一个二维数组来充当棋盘
	private String[][] board;

	public void initBoard() {
		// 初始化棋盘数组
		board = new String[BOARD_SIZE][BOARD_SIZE];
		// 把每个元素赋为"╋"，用于在控制台画出棋盘
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = "╋";
			}
		}
	}

	// 在控制台输出棋盘的方法
	public void printBoard() {
		// 打印每个数组元素
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				// 打印数组元素后不换行
				System.out.print(board[i][j]);
			}
			// 每打印完一行数组元素后输出一个换行符
			System.out.print("\n");
		}
	}

	public static void main(String[] args) throws Exception {
		Gobang gb = new Gobang();
		gb.initBoard();
		gb.printBoard();
		// 这是用于获取键盘输入的方法
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine()：每当在键盘上输入一行内容按回车，用户刚输入的内容将被br读取到。
		while ((inputStr = br.readLine()) != null) {
			// 将用户输入的字符串以逗号（,）作为分隔符，分隔成2个字符串
			String[] posStrArr = inputStr.split(",");
			// 将2个字符串转换成用户下棋的座标
			int xPos = Integer.parseInt(posStrArr[0]);
			int yPos = Integer.parseInt(posStrArr[1]);
			// 把对应的数组元素赋为"●"。
			gb.board[yPos - 1][xPos - 1] = "●";
			/*
			 * 电脑随机生成2个整数，作为电脑下棋的座标，赋给board数组。 还涉及 1.座标的有效性，只能是数字，不能超出棋盘范围
			 * 2.如果下的棋的点，不能重复下棋。 3.每次下棋后，需要扫描谁赢了
			 */
			gb.printBoard();
			System.out.println("请输入您下棋的座标，应以x,y的格式：");
		}
	}

	public boolean CheckWin(int xIndex, int yIndex) {
		int[][] a = null;
		int max = 0;
		int tempXIndex = xIndex;
		int tempYIndex = yIndex;
		// 三维数组记录横向，纵向，左斜，右斜的移动
		int[][][] dir = new int[][][] {
				// 横向
				{ { -1, 0 }, { 1, 0 } },
				// 竖着
				{ { 0, -1 }, { 0, 1 } },
				// 左斜
				{ { -1, -1 }, { 1, 1 } },
				// 右斜
				{ { 1, -1 }, { -1, 1 } } };

		for (int i = 0; i < 4; i++) {
			int count = 1;
			// j为0,1分别为棋子的两边方向，比如对于横向的时候，j=0,表示下棋位子的左边，j=1的时候表示右边
			for (int j = 0; j < 2; j++) {
				boolean flag = true;
				/**
				 * while语句中为一直向某一个方向遍历 有相同颜色的棋子的时候，Count++
				 * 否则置flag为false，结束该该方向的遍历
				 **/
				while (flag) {
					tempXIndex = tempXIndex + dir[i][j][0];
					tempYIndex = tempYIndex + dir[i][j][1];
					if ((a[tempXIndex][tempYIndex] == a[xIndex][yIndex])) {
						count++;
						System.out.println(count);
					} else
						flag = false;
				}
				tempXIndex = xIndex;
				tempYIndex = yIndex;
			}

			if (count >= 5) {
				max = 1;
				break;
			} else
				max = 0;
		}
		if (max == 1)
			return true;
		else
			return false;
	}
}
