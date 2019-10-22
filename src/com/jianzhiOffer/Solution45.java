package com.jianzhiOffer;

import java.util.Arrays;

//扑克牌顺子
public class Solution45 {
    public static boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length<5){
            return false;
        }
        //先排序,排序后就可以实现删0的功能，也可以实现判断是否有重复元素的功能
        Arrays.sort(numbers);
        //1.删0
        int i = 0;
        while(numbers[i] == 0){
            i++;
        }
        //2.剩下的数字判断有无重复
        for(int j = i+1; j<numbers.length; j++){
            if(numbers[j-1] == numbers[j]){
                return false;
            }
        }
        //max - min <= 4
        if(numbers[numbers.length-1] - numbers[i]<=4){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {3,4,0,6,7};
        int[] arr2 = {8,9,10,11,12};
        System.out.println(isContinuous(arr1));
        System.out.println(isContinuous(arr2));
    }
}
