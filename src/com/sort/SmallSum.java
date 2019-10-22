package com.sort;

//小和问题
//每一个数左边比当前数小的数累加起来
public class SmallSum {
    public static int smallSum(int[] arr) {
        return mergeSort(arr,0,arr.length-1);
    }

    public static int mergeSort(int[] arr, int left, int right) {
        //base case
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        return mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right) + merge(arr, left, mid, right);

    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int[] res = new int[right - left + 1];
        int index = 0;
        int smallSum = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                res[index++] = arr[i];
                smallSum = smallSum + arr[i] * (right - j + 1);
                i++;
            } else {
                res[index++] = arr[j++];
            }
        }

        while (i <= mid) {
            res[index++] = arr[i++];
        }

        while (j <= right) {
            res[index++] = arr[j++];
        }

        for (int k = 0; k < res.length; k++) {
            arr[left + k] = res[k];
        }
        return smallSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int smallSum = smallSum(arr);
        System.out.println(smallSum);
    }
}
