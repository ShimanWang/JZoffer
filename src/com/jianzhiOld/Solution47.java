package com.jianzhiOld;

//礼物的最大价值
public class Solution47 {
    public static int getMaxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] f = new int[n+1][m+1];

        //f[i][j]是从左上角第一个点走到i,j这个点能拿到的礼物最大数值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i-1][j],f[i][j-1]) + grid[i-1][j-1];
            }
        }
        return f[n][m];
    }

    //暴力递归的方法
    public static int getMaxValue2(int[][] grid) {
        return process(grid,0,0);
    }

    public static int process(int[][] matrix, int i, int j){
        //base case
        if (i == matrix.length-1 && j == matrix[0].length-1){
            return matrix[i][j];
        }
        if(i == matrix.length-1){
            return matrix[i][j]+process(matrix,i,j+1);
        }
        if(j == matrix[0].length-1){
            return matrix[i][j]+process(matrix,i+1,j);
        }

        int right = process(matrix,i,j+1);
        int down = process(matrix,i+1,j);
        return Math.max(right,down)+matrix[i][j];
    }

    public static void main(String[] args) {
        int[][] arr = {{2,3,1},{1,7,1},{4,6,1}};
        System.out.println(getMaxValue(arr));
        System.out.println(getMaxValue2(arr));
    }
}
