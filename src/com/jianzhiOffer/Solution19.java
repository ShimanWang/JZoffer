package com.jianzhiOffer;

import java.util.ArrayList;

//顺时针打印矩阵
public class Solution19 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a<=c && b<=d){
            printCircle(matrix,a,b,c,d,list);
            a++;
            b++;
            c--;
            d--;
        }
        return list;
    }

    //打印外边框
    public ArrayList<Integer> printCircle(int[][] matrix, int a, int b, int c, int d, ArrayList<Integer> list) {
        if (a == c) {
            for (int i = b; i <= d; i++) {
                list.add(matrix[a][i]);
            }
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                list.add(matrix[i][b]);
            }
        }else {
            int curRow = a;
            int curCol = b;
            while (curCol != d){
                list.add(matrix[a][curCol++]);
            }
            while (curRow != c){
                list.add(matrix[curRow++][d]);
            }
            while (curCol != b){
                list.add(matrix[c][curCol--]);
            }
            while (curRow != a){
                list.add(matrix[curRow--][b]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int[][] matrix2 = { {1}, { 2 }, { 3 },
                { 4 } };
        Solution19 s19 = new Solution19();
        ArrayList<Integer> list = s19.printMatrix(matrix2);
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}
