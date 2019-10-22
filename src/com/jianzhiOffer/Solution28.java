package com.jianzhiOffer;

//数组中出现次数超过一半的数字
//解析：超过一半就是比其余的数之和还要多
public class Solution28 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int count = 0;
        int value = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                count++;
            }else if (count > 0){
                count --;
            }else if(count == 0){
                value = array[i];
                count++;
            }
        }

        //最后加一次循环，记录这个数字的个数看是否大于数组一半
        int time = 0;
        for(int a : array){
            if(a == value){
                time++;
            }
        }
        if(time > array.length/2){
            return value;
        }else {
            return 0;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,4,2,5,2,3};
        int res = MoreThanHalfNum_Solution(arr);
        System.out.println(res);
    }
}
