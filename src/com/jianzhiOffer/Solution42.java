package com.jianzhiOffer;

import java.util.ArrayList;

//和为s的两个数字
public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array==null || array.length<2){
            return list;
        }
        int i = 0;
        int j = array.length-1;
        while(i<j){
            if(array[i] + array[j] == sum){
                list.add(array[i]);
                list.add(array[j]);
                break;
            }
            while(i<j && array[i] + array[j] < sum){ i++;}
            while(i<j && array[i] + array[j] > sum){ j--;}
        }
        return list;
    }
}
