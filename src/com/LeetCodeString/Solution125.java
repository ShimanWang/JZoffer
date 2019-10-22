package com.LeetCodeString;

import com.wsmOffers.day01.IsPalindrom;

public class Solution125 {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        char[] arr = str.toCharArray();


        StringBuffer str2 = new StringBuffer("");
        for(int k = 0;k<arr.length;k++){
            if(arr[k]>='a'&&arr[k]<='z' ||arr[k]>='0'&&arr[k]<='9'){
                str2.append(arr[k]);
            }
        }
        str = str2.toString();
        arr = str.toCharArray();


        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] == ' ') {
                i++;
            }
            if (arr[j] == ' ') {
                j--;
            }
            if (arr[i] != arr[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man a ,,plan a canal Panama";
        System.out.println(isPalindrome(str));
    }
}
