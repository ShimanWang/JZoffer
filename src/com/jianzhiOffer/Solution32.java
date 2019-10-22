package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//把数组排成最小的数
//贪心策略
public class Solution32 {
    public static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }

    public static String PrintMinNumber(int [] arr) {
        String res = "";

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            list.add(arr[i]+"");
        }

        Collections.sort(list,new MyComparator());
        for(String s : list){
            res = res + s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,32,321};
        System.out.println(PrintMinNumber(arr));

    }
}
