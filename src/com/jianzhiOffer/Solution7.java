package com.jianzhiOffer;

//斐波那契数列
public class Solution7 {
    //暴力递归做法
    public int fibonacci1(int n) {
        if(n == 1 || n == 2){
            return 1;
        }else {
            return fibonacci1(n-1) + fibonacci1(n-2);
        }
    }

    //动态规划做法
    public static int fibonacci2(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int prePre = 0;
        int pre = 1;
        int res = 0;
        while (n > 1){
           res = pre + prePre;
           prePre = pre;
           pre = res;
           n--;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = fibonacci2(7);
        System.out.println(res);
    }
}
