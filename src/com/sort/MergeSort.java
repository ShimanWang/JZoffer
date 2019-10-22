package com.sort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        //base case
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int[] res = new int[right - left + 1];
        int index = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                res[index] = arr[i];
                i++;
                index++;
            } else {
                res[index++] = arr[j++];
            }
        }

        while (i <= mid) {
            res[index] = arr[i];
            i++;
            index++;
        }

        while (j <= right) {
            res[index++] = arr[j++];
        }

        for (int k = 0; k < res.length; k++) {
            arr[left + k] = res[k];
        }
    }


    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 7, 9, 2, 4};
//        merge(arr, 0, 4, arr.length - 1);
        int[] arr = {1, 9, 0, 2, 5, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
