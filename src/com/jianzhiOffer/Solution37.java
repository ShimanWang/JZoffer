package com.jianzhiOffer;

//数字在排序数组中出现的次数
public class Solution37 {
    public static int GetNumberOfK(int [] array , int k) {
        if(array==null || array.length==0){
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while(left<right){
            int mid = (left+right)/2;
            if(array[mid] < k){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        //判断一下，如果找到的最后一个数不是k，则k不存在array中
        if(array[left]!=k){
            return 0;
        }
        int l1 = left;//找到了第一个点，再找第二个点

        left = 0;
        right = array.length - 1;
        while(left < right){
            int mid = (left+right+1)/2;
            if(array[mid] > k){
                right = mid-1;
            }else {
                left = mid;
            }
        }
        int l2 = left;
        return l2-l1+1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int num = GetNumberOfK(array,3);
        System.out.println(num);
    }
}
