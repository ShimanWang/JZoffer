package com.jianzhiOffer;

import java.util.Arrays;

//调整数组顺序使奇数位于偶数前面
public class Solution13 {
    public static void reOrderArray1(int[] array) {
        int len = array.length;
        int odd = -1;
        int even = len;
        int left = 0;
        int right = len - 1;
        while (even - left > 1) {
            if (array[left] % 2 != 0) {
                odd++;
                left++;
            } else {
                swap(array, left, --even);
            }
        }

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //稳定性，保证证奇数和奇数，偶数和偶数之间的相对位置不变
    public static void reOrderArray2(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int len = array.length;
        int[] res = new int[len];
        int oddNum = 0;
        int oddBegin = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 != 0){
                oddNum++;
            }
        }

        for(int i = 0; i < len; i++){
            if (array[i] % 2 != 0){
                res[oddBegin++] = array[i];
            }else {
                res[oddNum++] = array[i];
            }
        }

        //把res的内容赋值给array
        for(int i = 0; i < len; i++){
            array[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 9, 4, 5, 3,0};
//        reOrderArray1(arr);
//        System.out.println(Arrays.toString(arr));

        reOrderArray2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
