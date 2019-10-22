package com.examination.Tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        long[] a = new long[n + 1];
        long[] b = new long[n + 1];
        long[] c = new long[n + 1];
        long res = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = cin.nextInt();
            b[i] = cin.nextInt();
            c[i] = a[i] - b[i];
            res = res+(b[i]*(n)-a[i]);
        }
        Arrays.sort(c,1,n+1);
        for(int i =n;i>=1;i--){
            res = res+(c[i]*(n-i+1));
        }
        System.out.println(res);
    }
}
