package com.jianzhiOffer;

//左旋字符串、左旋数组
//三次翻转
public class Solution43 {
    public static String leftRotateString(String str,int n) {
        char[] arr = str.toCharArray();
        int i=0;
        int j = arr.length-1;
        //牛客上要加一个判断，判断n与str长度发的关系
        if(n>arr.length){
            return "";
        }
        reverse(arr,i,j);
        reverse(arr,i,j-n);
        reverse(arr,j-n+1,j);
        String res = "";
        for(char a : arr){
            res = res+a;
        }
        return res;
    }

    public static void reverse(char[] arr,int i,int j){
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String res = leftRotateString("abcdef",2);
        System.out.println(res);
    }
}
