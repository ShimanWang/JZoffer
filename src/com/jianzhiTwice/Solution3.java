package com.jianzhiTwice;

public class Solution3 {
    public static boolean Find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int i = row - 1;
        int j = 0;

        boolean flag = false;
        while (j < col && i >= 0) {
            if (array[i][j] > target) {
                i--;
            } else if (array[i][j] < target) {
                j++;
            } else {
                flag = true;
                break;

            }
        }
        return flag;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{2,3,4,5}};
        System.out.println(Find(1,arr));
    }
}
