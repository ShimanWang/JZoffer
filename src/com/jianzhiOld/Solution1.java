package com.jianzhiOld;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字2或者3。
 * https://www.cnblogs.com/yongh/p/9318604.html
 */

public class Solution1 {
    public static int dupInArray(int[] arr) {
        int n = arr.length;
        for (int a : arr) {
            if (a < 0 || a > n - 1) {
                return -1;
            }
        }
        int i = 0;
        while (i < n) {
            if(arr[i] != i){
                if(arr[i] == arr[arr[i]]){
                    return arr[i];
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,1,-10,1,1,4,3,10,1,1};
        System.out.println(dupInArray(arr1));
    }
}
