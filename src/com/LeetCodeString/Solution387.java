package com.LeetCodeString;

import java.util.Arrays;

public class Solution387 {
    public static int firstUniqChar(String str) {
        char[] arr = str.toCharArray();
        int[] word = new int[26];
        for (int i = 0; i < word.length; i++) {
            word[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            word[index]++;
        }
        System.out.println(Arrays.toString(word));

        for (int i = 0; i < arr.length; i++) {
            if(word[arr[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
//        char a = 'a';
//        System.out.println(a-'a');
    }
}
