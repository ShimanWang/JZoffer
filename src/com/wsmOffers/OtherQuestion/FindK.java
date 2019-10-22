package com.wsmOffers.OtherQuestion;

import java.util.Arrays;

//在N个乱序的数组中找第K大的数
public class FindK {
    public static int findK(int[] arr, int k, int left, int right) {
        int[] p = partition(arr, left, right);
        if (p[0] <= k - 1 && p[1] >= k - 1) {
            return arr[p[0]];
        } else if (p[1] < k - 1) {//右半部分继续partition
            return findK(arr, k, p[1] + 1, right);
        } else {//左半部分继续partition
            return findK(arr, k, left, p[0] - 1);
        }
    }


    public static int[] partition(int[] arr, int left, int right) {
        int num = arr[right];
        int more = left - 1;
        int less = right + 1;

        while (left < less) {
            if (arr[left] == num) {
                left++;
            } else if (arr[left] > num) {
                swap(arr, ++more, left++);
            } else {
                swap(arr, --less, left);
            }
        }
        int[] p = {more + 1, less - 1};
        return p;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 1, 3, 4};
        System.out.println(Arrays.toString(arr));
        //int res = findK(arr, 4, 0, arr.length - 1);
        int res = findK(arr, 5, 0, arr.length - 1);
        System.out.println(res);
    }
}
