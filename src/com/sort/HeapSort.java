package com.sort;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] arr){
        for(int i = 0;i<arr.length;i++){
            heapInsert(arr,i);
        }

        int heapSize = arr.length;

        while(heapSize>0){
            swap(arr,0,--heapSize);
            heapify(arr,0,heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int largest;

        while (left < heapSize) {
            if (left + 1 < heapSize && arr[left] < arr[left + 1]) {
                largest = left + 1;
            } else {
                largest = left;
            }

            if(arr[index] > arr[largest]){
                break;
            }else {
                swap(arr,index,largest);
                index = largest;
                left = index * 2 + 1;
            }

        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {3,1,8,1,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
