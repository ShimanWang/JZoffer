package com.jianzhiOffer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Solution35 {
    public static int InversePairs(int [] array) {
        if(array.length<=1){
            return 0;
        }
        return mergeSort(array,0,array.length-1);
    }

    public static int mergeSort(int[] arr, int left, int right){
        if(left>=right){
            return 0;
        }
        int mid = (left+right)/2;
        return mergeSort(arr,left,mid)+mergeSort(arr,mid+1,right)+merge(arr,left,mid,right);
    }

    public static int  merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        int num = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                help[index++] = arr[i++];
            } else {
                num = num+(mid-i+1);
                num = num%1000000007;
                help[index++] = arr[j++];
            }
        }

        while (i <= mid){
            help[index++] = arr[i++];
        }

        while (j <= right){
            help[index++] = arr[j++];
        }

        for(int k = 0; k<right-left+1; k++){
            arr[left+k] = help[k];
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {13, 6, 9, 11, 5};
        System.out.println(InversePairs(arr));
    }
}
