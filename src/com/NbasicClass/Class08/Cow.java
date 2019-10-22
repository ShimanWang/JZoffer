package com.NbasicClass.Class08;

public class Cow {
    public static int cowNum(int n){
        if(n<=0){
            return 0;
        }
        if(n==1 || n==2 || n==3){
            return n;
        }
        return cowNum(n-1)+cowNum(n-3);
    }

    public static void main(String[] args) {
        System.out.println(cowNum(2));
        System.out.println(cowNum(3));
        System.out.println(cowNum(4));
        System.out.println(cowNum(5));
        System.out.println(cowNum(6));
        System.out.println(cowNum(7));
    }

}
