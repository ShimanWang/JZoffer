package com.jianzhiOffer;

//数组中重复的数字
public class Solution50 {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || numbers.length<=0||numbers.length!=length){return false;}
        int i = 0;
        while(i<length){
            if(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                int index = numbers[i];
                numbers[i] = numbers[index];
                numbers[index]=index;
            }else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        int[] res = new int[1];
        System.out.println(duplicate(arr,7,res));
    }
}
