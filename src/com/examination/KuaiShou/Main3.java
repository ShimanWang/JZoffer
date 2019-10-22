package com.examination.KuaiShou;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        print(n);

    }

    public static void print(int n) {
        process(1,n,true);
    }

    //满二叉树的中序遍历
    public static void process(int i, int n, boolean down) {
        if(i>n){
            return;
        }
        process(i+1,n,false);
        if(down){
            System.out.println("down");
        }else {
            System.out.println("up");
        }
        //System.out.println(down?"down":"up");
        process(i+1,n,true);
    }
}
