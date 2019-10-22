package com.jianzhiOld;

import com.sun.tools.javah.LLNI;

/**
 * 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
 * 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 * 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
 * 输出是重复的数字2或者3。
 */
public class Solution2 {
    public static int getNum(int[] arr){
        int low = 1;
        int high = arr.length - 1;
        return process(low,high,arr);
    }

    public static int process(int low, int high, int[] arr){
        if(low == high){
            return low;
        }
        int mid = (low + high)/2;
        int count1 = getCount(low,mid,arr);//只需要统计low到mid的个数，mid+1到high的个数走else
//        int count2 = getCount(mid+1,high,arr);
        if(count1 > mid-low+1){
            return process(low,mid,arr);
        }else {
            return process(mid+1,high,arr);
        }
    }

    //统计low 到 high 共有多少个数字
    public static int getCount(int low, int high, int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] >= low && arr[i] <= high){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        int res = getNum(arr);
        System.out.println(res);
    }
}
