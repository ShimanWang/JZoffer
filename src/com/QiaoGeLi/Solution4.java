package com.QiaoGeLi;

//反转字符串
public class Solution4 {
    public static String reverseString1(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0 || str.length() == 1) {
            return str;
        }
        int i = 0;
        int j = str.length() - 1;
        char[] arr = str.toCharArray();
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        String res = "";
        for(char c :arr){
            res+=c;
        }
        return res;
    }


    public static void main(String[] args) {
        String str1 = "hello";
        String resStr1 = reverseString1(str1);
        System.out.println(resStr1.toString());
    }
}
