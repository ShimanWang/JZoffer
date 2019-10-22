package com.jianzhiOffer;

//不用加减乘除做加法
public class Solution48 {
    public int Add(int num1,int num2) {
        while(num2!=0){
            //没有进位情况下的和
            int sum = num1 ^ num2;
            //所有的进位，由于进位是往高一位进位，所以结果左移1位
            int carry = (num1 & num2) << 1;
            //sum+carry就是最后的结果,迭代来求和
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
