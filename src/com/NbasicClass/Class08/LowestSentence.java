package com.NbasicClass.Class08;

import java.util.Arrays;
import java.util.Comparator;

//贪心第一题：把数组排成最小的数（具有最小的字典序）
public class LowestSentence {

    //1.先搞一个比较器
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }

    public static String lowestString(String[] arr){
        if(arr.length==0 || arr == null){
            return null;
        }

//        Arrays.sort(arr,new MyComparator());
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String res = "";
        for(int i = 0; i<arr.length; i++){
            res += arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"ab","a"};
        System.out.println(lowestString(arr));
    }
}
