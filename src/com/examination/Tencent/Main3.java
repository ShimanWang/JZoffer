package com.examination.Tencent;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[] arr = new int[n+1];
        arr[0] = 0;
        for (int i = 1; i < n+1; i++) {
            arr[i] = cin.nextInt();
        }
        solution(n,m,arr);

    }

    public static void solution(int n,int m, int[] arr){
        int[] person = new int[n+1];
        person[0] = m;

    }
}
