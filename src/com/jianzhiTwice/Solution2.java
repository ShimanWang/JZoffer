package com.jianzhiTwice;

//给定一个长度为 n+1 的数组nums，数组中所有的数均在 1∼n 的范围内，其中 n≥1。
//请找出数组中任意一个重复的数，但不能修改输入的数组。
//nums = [2, 3, 5, 4, 3, 2, 6, 7]
public class Solution2 {
    public static int solution(int[] arr) {
        return process(arr, 1, arr.length - 1);
    }

    public static int process(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        //base case
        if (low == high) {
            return low;
        }
        int count = countNum(arr, low, mid);
        if (count > mid - low + 1) {
            high = mid;
            return process(arr, low, high);
        } else {
            low = mid + 1;
            return process(arr, low, high);

        }
    }

    public static int countNum(int[] arr, int low, int high) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= low && arr[i] <= high) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 20, 12, 4, 14, 6, 13, 19, 5, 4, 18, 5, 16, 11, 10, 13, 5, 3, 2, 12};
        System.out.println(solution(arr));

    }
}
