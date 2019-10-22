package com.jianzhiOld;

//0~n-1中缺失的数字
public class Solution55 {
    public static int getMissingNumber(int[] arr) {
        int n = arr.length;
        int sumTarget = (0 + n) * (n + 1) / 2;

        int sumArr = 0;
        for (int i = 0; i < arr.length; i++) {
            sumArr = sumArr + arr[i];
        }
        //System.out.println("sumTarget="+sumTarget);
        //System.out.println("sumArr="+sumArr);
        return sumTarget - sumArr;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0};
        System.out.println(getMissingNumber(arr));
    }
}
