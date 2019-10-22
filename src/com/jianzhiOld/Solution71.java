package com.jianzhiOld;

//股票的最大利润
public class Solution71 {
    public static int maxDiff(int[] nums) {
        if(nums==null||nums.length<=0){return 0;}
        //之前日子里股价的最小值
        int minValue = nums[0];
        int dif = 0;
        int maxVal = 0;
        for(int i = 1;i<nums.length;i++){
            dif = nums[i]-minValue;
            minValue = Math.min(minValue,nums[i]);
            maxVal = Math.max(dif,maxVal);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxDiff(arr));
    }
}
