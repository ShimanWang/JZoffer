package com.jianzhiOffer;

public class Solution1 {
    public static boolean Find(int target, int [][] array) {
        int row = array.length;//行
        int col = array[0].length;//列
        int i = row - 1;
        int j = 0;

        while (i>=0 && j <= col-1){
            if (array[i][j] > target){
                i--;
            }else if(array[i][j] < target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{2,3,4,5}};
        System.out.println(Find(1,arr));
    }
}
