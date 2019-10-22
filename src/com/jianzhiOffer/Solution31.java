package com.jianzhiOffer;

//从1到n整数中1出现的次数
/*
* 高位：n/i
* 底位：n%i
* */

public class Solution31 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n == 0 ){
            return 0;
        }
        int count = 0;

        //i只管循环次数（也就是一共最高位是多少位）
        for(int i = 1; i <= n; i = i*10){
            int a = n/i;
            int b = n%i;
            if(a%10 >= 2){
                count = count +(a/10+1)*i;

            }else if(a%10 == 1){
                count = count +(a/10)*i + (b+1);

            }else if(a%10 == 0){
                count = count +(a/10)*i;
            }
        }

        return count;

    }

    public static void main(String[] args) {
//        int n = 1234;
//        int n1 = n/10;
//        int n2 = n%10;
//        System.out.println(n1);
//        System.out.println(n2);
        int n = 13;
        int count = NumberOf1Between1AndN_Solution(n);
        System.out.println(count);

    }
}
