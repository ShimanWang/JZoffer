package com.jianzhiOffer;

//翻转单词顺序
public class Solution44 {
    public String reverseWords(String str) {
        char[] arr = str.toCharArray();
        //1.全部翻转
        reverse(arr,0,arr.length-1);
        reverseWord(arr);
        String res = "";
        for(char a : arr){
            res = res+a;
        }
        return res;
    }

    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void reverseWord(char[] arr){
        int i = 0;
        int j = 0;

        while (i<arr.length && j<arr.length){
            while (arr[i]==' '){i++;}
            while (arr[j]!=' ' || j<= i){
                j++;
                if(j == arr.length){
                    break;
                }
            }
            reverse(arr,i,j-1);
            i=j;
        }
    }

    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        String res = solution44.reverseWords("Hello World");
        System.out.println(res);
    }
}
