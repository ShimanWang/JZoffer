package com.examination.BeiKe;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        int n = cin.nextInt();
        int len = 0;
        int[] dp = new int[n];

        while(n!=0){
            int a = cin.nextInt();
            if(len == 0 || dp[len-1]<=a){
                dp[len++] = a;
            }else {
                int left = 0;
                int right = len;

                while(left<=right){
                    int mid = (left+right)/2;
                    if(dp[mid]>a){
                        right = mid-1;
                    }else {
                        left = mid+1;
                    }
                }
                dp[left] = Math.min(dp[left],a);
            }
            n--;
        }
        System.out.println(len);
    }
}
