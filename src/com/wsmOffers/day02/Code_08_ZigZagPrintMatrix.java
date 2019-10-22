package com.wsmOffers.day02;

//之字形打印矩阵
public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int aR = 0;//a点的行号和列号
		int aC = 0;
		int bR = 0;//b点的行号和列号
		int bC = 0;
		int endR = matrix.length - 1;//结束位置
		int endC = matrix[0].length - 1;
		boolean fromUp = false;
		//如果a点的行号来到了最后一行，证明a点不仅走完了右移部分，也走完了下移部分（即走到了最后）
		//也可以写b点来到最后一列，这俩条件一定对应的是同一时刻
		while (aR != endR + 1) {
			printLevel(matrix, aR, aC, bR, bC, fromUp);
			aR = aC == endC ? aR + 1 : aR;//a来到最后一列了，a的行号+1，否则a的行号不变
			aC = aC == endC ? aC : aC + 1;
			bC = bR == endR ? bC + 1 : bC;
			bR = bR == endR ? bR : bR + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int aR, int aC, int bR, int bC,
			boolean f) {
		if (f) {//右上往左下打印
			while (aR != bR + 1) {
				System.out.print(m[aR++][aC--] + " ");
			}
		} else {//左下往右上打印
			while (bR != aR - 1) {
				System.out.print(m[bR--][bC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
