package com.wsmOffers.OtherQuestion;

//写一个函数，不用加法和乘法，返回它的8倍
public class EightTimes {
    public static int eightTimes(int p){
        return p<<3;
    }


    public static void main(String[] args) {
        System.out.println(eightTimes(2));
    }
}
