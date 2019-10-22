package com.jianzhiOld;

//把数字翻译成字符串
/*
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0翻译成"a"，1翻译成"b"，……，11翻译成"l"，……，25翻译成"z"
 * 一个数字可能有多个翻译
 * 例如12258有5种不同的翻译，
 * 它们分别"bccfi", "bwfi", "bczi", "mcfi" 和"mzi"
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法
 * */
public class Solution46 {
    public static int getTranslationCount(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] f = new int[n];  //动态规划

        f[0] = 1;

        for (int i = 1; i < n; i++) {
            f[i] = f[i-1];
            int t = (arr[i-1] -'0')*10 + (arr[i]-'0');
            if (t>=10 && t<=25){
                if(i-2<0){
                    f[i] = f[i]+1;
                }else{
                    f[i] = f[i]+f[i-2];
                }
            }

        }

        return f[n-1];
    }

    public static void main(String[] args) {
        System.out.println(getTranslationCount("10"));
        System.out.println(getTranslationCount("122"));
        System.out.println(getTranslationCount("12258"));
    }
}
