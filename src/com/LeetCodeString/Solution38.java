package com.LeetCodeString;
//报数
//1
//11
//21
//1211
//111221
public class Solution38 {
    public static String countAndSay(int n) {
        String init = "1";
        for(int i = 1; i<n; i++){
            String temp = "";
            char[] arr = init.toCharArray();

            for(int j=0; j<init.length(); ){
                int count = 0;//count需要每次循环重新计数
                int u = j;
                while (u < init.length() && arr[u] == arr[j]){
                    u++;
                    count++;//数一下连续字符串有多少个
                }
                temp =temp + count+"" + arr[j]+"";
                j = u;
//                System.out.println(temp);
            }
            init = temp;
        }
        return init;
    }

    public static void main(String[] args) {
        countAndSay(4);
        System.out.println(countAndSay(5));
    }
}
