package com.wsmOffers.day02;

import java.util.Arrays;

public class PartitionTest {
    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 1, 7,3,3};
//        int[] res = partition(arr,0,arr.length-1);
//        System.out.println(res[0]);
//        System.out.println(res[1]);
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left<right){
            int[] p = partition(arr,left,right);
            quickSort(arr,left,p[0]-1);
            quickSort(arr,p[1]+1,right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right + 1;
        int num = arr[right];
        while (left<more) {
            if (arr[left] == num) {
                left++;
            }else if(arr[left] < num){
                swap(arr,++less,left++);
            }else {
                swap(arr,left,--more);
            }
        }
        int[] p = {less+1,more-1};
        return p;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
