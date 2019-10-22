package com.jianzhiOffer;

//连续子数组的最大和
//动态规划
public class Solution30 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int curSum = 0;
        //为防止整个array数组中都是负数，greatSum设为系统最小值
        int greatSum = Integer.MIN_VALUE;//类似一个全局变量，里面始终保存着当前的连续子数组的最大和
        for(int i = 0; i < array.length; i++){
            if(curSum <= 0 ){
                curSum = array[i];
            }else{
                curSum = curSum + array[i];
            }

            if(curSum > greatSum){
                greatSum = curSum;
            }
        }
        return greatSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int greatSum = FindGreatestSumOfSubArray(arr);
        System.out.println(greatSum);
    }
}
