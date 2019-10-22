package com.examination.JD;

import java.util.Scanner;

//输入第一行仅包含一个正整数n，表示字符串的长度(1<=n<=1000000)。
//输入第二行包含一个长度为n的字符串，仅包含大小写字母。
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        String str = cin.next();
        if (str.length() == n) {
            soution(str);
        } else {
            System.out.println("-1");
        }

    }

    public static void soution(String str) {
        int time = str.length();
        int time1 = time;
        int time2 = time;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {

        }
        System.out.println(time + 2);
    }
}
