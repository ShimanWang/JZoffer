package com.jianzhiOld;

//数字序列中某一位的数
/*
* 0123456789 10 11 12 ... 99  100...999  1000...9999...【第0位是0】
* 求这个数字序列中的第n位数字是多少
* 1位数：10个（不含0就是9个）
* 2位数：90个
* 3位数：900个
* */
public class Solution44 {
    public static int digitAtIndex(int n) {
        //1.先确定是几位数
        //为了方便理解，把第0位的0去掉，从1开始计算
        int i = 1;//位数（1位、2位、3位...）
        int s = 9;//某一位数字有多少个：9、90、900...
        int base = 1;//第i位数字的起始值:1、10、100、1000
        while (n - i * s > 0){
            n = n-i*s;
            i++;
            s = s*10;
            base = base*10;
        }

        //经过while循环后 : 第i位数字中的第n个数[例如：4(i)位数字中的第1000(n)位是属于哪个数的]
        //下面确定是i位数中的第几个数字
        //向上取整：1001位/4 = 250...1  ---第4位数字中的第1001个数属于第251个数
        int temp = (int)Math.ceil((double)n/i);
        int number = base + (int)Math.ceil((double)n/i) -1 ;  //确定出来了第n位数字是属于哪个数的
        //然后看一下是number这个数中的第几位
        int r;
        if(n%i == 0){
            r = i;
        }else {
            r = n%i;
        }
        //下面求一下number的第r位数字是什么
        if(r == i){//最后一位
            return number % 10;
        }else{
            //第r位：去掉末尾的i-r位数字
            for(int j = 0; j<i-r; j++){
                number = number/10;
            }
            return number % 10;
            //都是return number % 10其实可以合并，但是为了方便理解代码，还是分来保留
        }
    }

    public static void main(String[] args) {
        for(int i = 1; i<100; i++){
            int res = digitAtIndex(i);
            System.out.print(res+" ");
        }
       // System.out.println((int)Math.ceil((double)1/2));
    }
}
