package com.jianzhiOld;

//数组中数值和下标相等的元素
public class Solution56 {
    public static int getNumberSameAsIndex(int[] arr) {
        if(arr==null||arr.length==0){
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left+right)/2;
            if(arr[mid] - mid < 0){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        if(arr[left] != left){
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {-3,-1,1,3,5};
        System.out.println(getNumberSameAsIndex(arr));
    }
}
