package com.jianzhiOffer;

//旋转数组的最小数字
public class Solution6 {
    public static int minNumberInRotateArray(int [] array) {
        int n = array.length;
        if (n == 0){
            return 0;
        }
        //没有旋转的情况
        if(array[0]<array[n-1]){
            return array[0];
        }

        //如果数组后半部分有相等的情况，将其干掉
        while (n>0 && array[0] == array[n-1]){
            n--;
        }
        if(n==0){//加这个是为了判断整个数组都是同一个值的情况
            return array[0];
        }


        int temp = array[0];
        int left = 0;
        int right = n-1;
        int min = 0;
        int mid;
        while (array[left] > array[right]){//left < right
            mid = (left + right)/2;
            if (right - left == 1){
                min = array[right];
                break;
            }
            if(array[mid] >= temp){
                left = mid;
            }else if(array[mid] < temp){
                right = mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {10,10,1,2,3,4,5,6,7,8};
        int[] array2 = {1,0,1,1,1};
        int[] array3 = {1,2,3,4,5};
        int[] array4 = {2,2,2,2};
        int res = minNumberInRotateArray(array4);
        System.out.println(res);
    }
}
