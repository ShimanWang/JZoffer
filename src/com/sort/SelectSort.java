package com.sort;

import java.util.Arrays;

public class SelectSort {
    public static void seleceSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;

        }
    }


    public static void main(String[] args) {
        int[] arr = {0,3,1,5,1,1};
        seleceSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
