package com.jianzhiTwice;

//找出数组中重复的数字
public class Solution1 {
    public static int solution(int[] arr) {
        int n = arr.length;
        for (int a : arr) {
            if (a < 0 || a > n - 1) {
                return -1;
            }
        }

        int i = 0;
        while (i < n) {
            if(arr[i] == i){
                i++;
            }else {

                if(arr[i] == arr[arr[i]]){
                    return arr[i];
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return -1;
    }
}
