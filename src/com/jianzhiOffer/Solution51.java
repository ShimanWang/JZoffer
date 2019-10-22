package com.jianzhiOffer;

//构建乘积数组
public class Solution51 {
    public int[] multiply(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        if (a == null || a.length == 0) {
            return b;
        }
        //p:前面所有数的乘积
        //先计算上三角部分
        int p = 1;
        for (int i = 0; i < len; i++) {
            b[i] = p;
            p = p * a[i];
        }
        //再计算倒三角部分
        p = 1;
        for (int i = len - 1; i >= 0; i--) {
            b[i] = b[i] * p;
            p = p * a[i];
        }
        return b;
    }
}
