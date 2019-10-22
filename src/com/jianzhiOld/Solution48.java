package com.jianzhiOld;

//最长不含重复字符的子字符串
public class Solution48 {
    public static int longestSubstringWithoutDuplication(String s) {
        char[] arr = s.toCharArray();
        int[] az = new int[26];
        int i = 0;
        int max = 0;

        for(int j = 0; j<s.length(); j++){
            int index = arr[j]-'a';
            if(az[index] <= 0){
                az[index] = 1;
            }else{
                az[index]++;
                while(az[index] > 1){
                    int leftIndex = arr[i]-'a';
                    az[leftIndex]--;
                    i++;
                }

            }
            if(j-i +1 > max){
                max = j - i + 1;
            }
        }
        return max;

    }

    public static void main(String[] args) {
//        System.out.println(longestSubstringWithoutDuplication("cabddce"));
        System.out.println(longestSubstringWithoutDuplication("qandlvepocembzeewem"));
    }
}
