package com.examination.DongFangCaiFu;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int x1;
        x1 = cin.nextInt();
        int y1;
        y1 = cin.nextInt();

        int x2;
        x2 = cin.nextInt();
        int y2;
        y2 = cin.nextInt();

        int x3;
        x3 = cin.nextInt();
        int y3;
        y3 = cin.nextInt();

//        double a = Math.pow((x1-x2),2) + Math.pow((y1-y2),2);
//        double b = Math.pow((x1-x3),2) + Math.pow((y1-y3),2);
//        double c = Math.pow((x3-x2),2) + Math.pow((y3-y2),2);
//
//        if(isTriangle(a,b,c)){
//            zhouChang(a,b,c);
//            mianJi(a,b,c);
//
//        }else {
//            System.out.println("Impossible");
//        }
        solution(x1,y1,x2,y2,x3,y3);

    }


    //判断是否为三角形
    public static boolean isTriangle(double a ,double b,double c){
        if(a+b>c && a+c>b && b+c>a){
            return true;
        }
        return false;
    }
    //计算三角形周长
    public static void zhouChang(double a,double b,double c){
        double res = a+b+c;
        BigDecimal big = new BigDecimal(res);
        double l = big.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(l));
    }
    //计算三角形面积
    public static void mianJi(double a,double b,double c){
        float s =(float) (a+b+c)/2;
        float area = (float)Math.sqrt(s*(s-a)*(s-b)*(s-c));

        BigDecimal big = new BigDecimal(area);
        double l = big.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(l));

    }

    public static void solution(int x1,int y1,int x2,int y2,int x3,int y3){
        float a,b,c;
        a = (float)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        b = (float)Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        c = (float)Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));

        if(a+b>c && a+c>b && b+c>a){
           float len;
           len = a+b+c;
           DecimalFormat df  = new DecimalFormat(".00");
           String l = df.format(len);
           System.out.println(l);

            float s = (a+b+c)/2;
            float area = (float)Math.sqrt(s*(s-a)*(s-b)*(s-c));
            String ar = df.format(area);
            System.out.println(ar);
        }else {
            System.out.println("Impossible");
        }
    }
}
