package com.examination.DiDi;

//第一行包含两个整数N和M，1≤N  N名员工  ，M个项目  ≤1000  例如：3 3
//接下来N行，每行包含M个整数，第i行的第j个整数表示Ai,j，1≤Ai,j≤1000。

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();

        int[] arr = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[j] = Math.max(arr[j], cin.nextInt());
            }
        }

        int max = 0;
        for (int k = 0; k < arr.length; k++) {

            max += arr[k];

        }
        System.out.println(max);


//        int[][] arr = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = cin.nextInt();
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }

    }

//    public static void solution(int[][] arr){
//        int colIndex = -1;
//
//    }
}
