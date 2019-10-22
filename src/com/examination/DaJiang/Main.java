package com.examination.DaJiang;

/**
 * 输入两个字符串 str1 和str2，输出它们公共的最长子串，
 * 如果有多个结果，请取较短字符串中从左到右最早出现的那个子串。请编程实现并在注释里简单描述算法思想。
 * 示例：输入 “asd12345qwer” 和 “asdd1234_5qwerfff”，输出 “d1234”
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        String str1;
//        str1 = cin.next();
//        String str2;
//        str2 = cin.next();
        String str1 = "asd12345qwer";
        String str2 = "asdd1234_5qwerfff";

        String res = solution(str1, str2);
        System.out.println(res);

    }

    public static String solution(String str1, String str2) {
        //异常情况判断
        if (str1 == null || str2 == null) {
            return null;
        }
        if (str1.equals("") || str2.equals("")) {
            return null;
        }
        if(str1.length()>1000||str2.length()>1000){
            return null;
        }
        //寻找二者中较长的字符串、较短的字符串
        String max = "";
        String min = "";

        if (str1.length() < str2.length()) {
            max = str2;
            min = str1;
        } else {
            min = str2;
            max = str1;
        }

        String res = "";
        //遍历较短字符串，并依次减少短字符串的字符数量，判断长字符串是否包含该子串
        for (int i = 0; i < min.length(); i++) {
            int begin;
            int end;
            for (begin = 0, end = min.length() - i; end <= min.length(); begin++, end++) {
                res = min.substring(begin, end);
                if (max.contains(res)) {
                    return res;
                }
            }
        }

        return null;
    }
}
