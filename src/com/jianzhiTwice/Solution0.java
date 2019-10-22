package com.jianzhiTwice;

import java.util.Scanner;

//闰年
public class Solution0 {
    public static boolean isRun(int years) {
        if (years < 0) {
            return false;
        }

        if (years % 400 == 0 || (years % 4 == 0 && years % 100 != 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.println(isRun(year));
    }
}
