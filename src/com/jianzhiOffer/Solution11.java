package com.jianzhiOffer;

//二进制中1的个数
public class Solution11 {
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            if ((n & 1) == 1){
                count ++;
            }
            n = n>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(3));
        System.out.println(NumberOf1(-3));
    }
}
