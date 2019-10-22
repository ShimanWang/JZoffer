package com.jianzhiTwice;

public class Solution4 {
    public static String replaceSpace(StringBuffer str) {
        char[] arr = str.toString().toCharArray();
        StringBuffer res = new StringBuffer("");
        for(int i=0;i<arr.length;i++){
            if(arr[i]==' '){
                res.append("%20");
            }else {
                res.append(arr[i]);
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        StringBuffer res = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(res));

    }
}
