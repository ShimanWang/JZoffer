package com.LeetCodeString;

public class Solution1512 {
    public static String reverseWords(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        reverse(arr, 0, s.length() - 1);
        reverseWord(arr);
        return deleteSpace(arr);
    }

    //翻转操作
    public static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    //翻转每一个单词
    public static void reverseWord(char[] arr) {
        int i = 0;
        int j = 0;
        int len = arr.length;
        while (i < len) {
            while (arr[i] == ' ') {
                i++;
            }
            while (arr[j] != ' ' || j < i) {
                j++;
                if (j == len) {
                    break;
                }
            }
            reverse(arr, i, j - 1);
            i = j;
        }
    }

    //处理单词间的空格
    public static String deleteSpace(char[] arr) {
        int i = 0;
        int j = 0;
        int len = arr.length;
        while (i < len) {
            while (i < len && arr[i] != ' ') {
                arr[j++] = arr[i++];
            }
            while (i < len && arr[i] == ' ') {
                i++;
            }
            if (i < len) {
                arr[j++] = ' ';
            }
        }
        return String.valueOf(arr).substring(0, j);
    }

    public static void main(String[] args) {
        String s = "    the     sky is blue";
        String res = reverseWords(s);
        System.out.println(res);
        System.out.println(res.length());
    }
}
