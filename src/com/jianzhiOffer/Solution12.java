package com.jianzhiOffer;

//数值的整数次幂
public class Solution12 {
    public static double power(double base, int exponent) {
        double res = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            res = res * base;
        }
        if(exponent<0){
            res = 1/res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(power(2,3));
    }
}
