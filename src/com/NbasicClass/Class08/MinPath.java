package com.NbasicClass.Class08;

import sun.nio.cs.ext.MS874;

public class MinPath {
    public static int minPath(int[][] matrix,int i, int j){
        //base case
        if( i==matrix.length-1 && j == matrix[0].length-1){
            return matrix[i][j];
        }

        //如果来到最后一行
        if(i == matrix.length-1){
            return matrix[i][j]+minPath(matrix,i,j+1);
        }
        //如果来到最后一列
        if(j == matrix[0].length-1){
            return matrix[i][j]+minPath(matrix,i+1,j);
        }

        //一般情况
        int right = minPath(matrix,i,j+1);
        int down = minPath(matrix,i+1,j);
        return matrix[i][j]+Math.min(right,down);
    }

    public static int minPath2(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] f = new int[row][col];

        f[0][0] = matrix[0][0];

        for(int i = 1; i<row; i++){
            f[i][0] = matrix[i][0]+f[i-1][0];
        }

        for(int j =1; j<col; j++){
            f[0][j] = matrix[0][j] + f[0][j-1];
        }

        for(int i = 1; i<row; i++){
            for(int j =1; j<col; j++){
                f[i][j] = Math.min(f[i-1][j],f[i][j-1]) +matrix[i][j];
            }
        }
        return f[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,2,1,0},{7,5,0,1},{3,7,6,2}};
        System.out.println(minPath(matrix,0,0));
        System.out.println(minPath2(matrix));
    }
}
