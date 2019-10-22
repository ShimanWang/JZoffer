package com.wsmOffers.OtherQuestion;

//最大公约数与最小公倍数
public class BigDivisor {
    public static int bigDivisor(int x,int y){
        int yuShu = -1;
        if(x > y){
           while (yuShu != 0){
               yuShu = x % y;
               x = y;
               y = yuShu;
           }
           return x;
        }else {
            while (yuShu != 0){
                yuShu = y % x;
                y = x;
                x = yuShu;
            }
            return y;
        }
    }

    public static int multiPle(int x,int y){
        return x*y/bigDivisor(x,y);
    }

    public static void main(String[] args) {
        int res1 = bigDivisor(13,24);
        System.out.println(res1);
        int res2 = multiPle(13,24);
        System.out.println(res2);

    }
}
