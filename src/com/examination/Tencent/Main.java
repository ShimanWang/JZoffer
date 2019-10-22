package com.examination.Tencent;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[] temp1 = new int[n];
        for (int i = 0; i < n; i++) {
            temp1[i] = cin.nextInt();
        }

        int[] temp2 = new int[m];

        for (int i = 0; i < m; i++) {
            temp2[i] = cin.nextInt();
        }

        solution(temp1, temp2);

    }

    public static void solution(int[] a, int[] b) {
        int countAou = 0;
        int countAji = 0;
        int countBou = 0;
        int countBji = 0;

        for (int i : a) {
            if (i % 2 == 0) {
                countAou++;
            } else {
                countAji++;
            }
        }

        for (int i : b) {
            if (i % 2 == 0) {
                countBou++;
            } else {
                countBji++;
            }
        }

        int count = 0;
        if (countAou >= countBji) {
            count = count + countBji;
        } else {
            count = count + countAou;
        }

        if (countAji >= countBou) {
            count = count + countBou;
        } else {
            count = count + countAji;
        }

        System.out.println(count);
    }
}
