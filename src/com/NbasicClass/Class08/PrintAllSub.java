package com.NbasicClass.Class08;

//打印全部子序列

import java.util.ArrayList;

public class PrintAllSub {
    /**
     *
     * @param arr
     * @param i  遍历到第i个位置
     * @param res  上级扔过来的字符串
     */
    public static void printAllSubString(char[] arr,int i, String res){
        //base case : i来到数组的最后一位(最后一位也遍历完了)
        if(i==arr.length){
            System.out.println(res);
            return;
        }
        printAllSubString(arr,i+1,res);
        printAllSubString(arr,i+1,res+arr[i]);
    }


    public static ArrayList printAllSubString2(char[] arr, int i, String res){
        ArrayList<String> list = new ArrayList<>();
        if(i==arr.length){
           list.add(res);
        }
        printAllSubString(arr,i+1,res);
        printAllSubString(arr,i+1,res+arr[i]);
        return list;
    }

    public static void main(String[] args) {

        printAllSubString("abc".toCharArray(),0,"");
        ArrayList<String > list = printAllSubString2("abc".toCharArray(),0,"");
        for(String s : list){
            System.out.println(s);
        }
    }
}
