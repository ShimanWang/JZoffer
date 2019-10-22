package com.LeetCodeArray;

//岛问题
public class Solution200 {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    xuanRan(grid,i,j,row,col);
                }
            }
        }
        return count;
    }

    //渲染函数
    public void xuanRan(char[][] arr,int i,int j, int row, int col){
        if(i < 0 || i >= row || j < 0 || j >= col || arr[i][j] != '1'){
            return;
        }
        arr[i][j] = '2';
        xuanRan(arr,i-1,j,row,col);
        xuanRan(arr,i+1,j,row,col);
        xuanRan(arr,i,j-1,row,col);
        xuanRan(arr,i,j+1,row,col);
    }

    public static void main(String[] args) {

    }
}
