package com.NbasicClass.Class08;

//给一个数组arr,可以选择arr中的任意数字,能否得到一个和为aim
public class IsSum {
    /**
     * @param arr 给的数组
     * @param i   当前来到的是第i位
     * @param sum 已经形成的和是sum
     * @param aim
     * @return
     */
    public static boolean isSum(int[] arr, int i, int sum, int aim) {
        if (i == arr.length) {
            return sum == aim;
        }

        return isSum(arr, i + 1, sum, aim) || isSum(arr, i + 1, sum + arr[i], aim);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,7,5};
        int aim = 9;
        System.out.println(isSum(arr,0,0,aim));
    }
}
