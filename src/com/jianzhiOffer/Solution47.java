package com.jianzhiOffer;

//1+2+3+…+n
//1.通项公式：（首项+末项）*项数 / 2(会用到乘法，不行)
//2.for循环
//3.递归
//短路与&&

//1.需利用逻辑与的短路特性实现递归终止
//2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0
//3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)
public class Solution47 {
    public static int Sum_Solution(int n) {
        int res = n;
        boolean a = (n>0) && ((res = res + Sum_Solution(n-1))>0);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Sum_Solution(10));
    }
}
