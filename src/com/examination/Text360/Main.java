package com.examination.Text360;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = cin.nextInt();
            }
        }
        solution(arr);

    }

    public static void solution(int[][] arr) {
        //共多少个正方体
        int num = 0;
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                num = num + arr[i][j];
            }
        }
        int s = num * 6;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                num = num -(arr[i][j]-1)*2;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m-1; j++) {
//                num = num -Math.min(arr[i][j],arr[i][j+1])*2;
//            }
//        }
//
//        for (int j = 0; j < m; j++) {
//            for (int i = 0; i < n-1; i++) {
//                num = num -Math.min(arr[i][j],arr[i+1][j])*2;
//            }
//        }


                //上下
                s = s - (arr[i][j] - 1)*2;
                //左右
                if(j+1<m){
                    int minCha = Math.min(arr[i][j],arr[i][j+1]);
                    s = s-2*minCha;

                }
                //前后
                if(i+1<n){
                    int minCha2 = Math.min(arr[i][j],arr[i+1][j]);
                    s = s-2*minCha2;
                }

            }
        }
        System.out.println(num);
    }
}
