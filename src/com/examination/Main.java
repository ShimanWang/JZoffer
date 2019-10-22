package com.examination;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
//        //Scanner in = new Scanner(System.in);
//        Scanner cin = new Scanner(System.in);
//        int n;
//        n = cin.nextInt();
//        //int[] arr = new int[n];
//        for(int i = 0;i<n;i++){
//            String b = cin.next();
//            String c = cin.next();
//            solution(b,c);
//        }
        String res2 = rev("1100");
        System.out.println(res2);

    }

    public static void solution(String str1,String str2){
        System.out.println("YES");
    }

    public static String rev(String str){
        char[] arr = str.toCharArray();
        String res="";
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == '0'){
                res = res+"1";
            }else {
                res = res+"0";
            }
        }

        char[] arr2 = res.toCharArray();
        int j =0;
        while(arr2[j] == '0'){
            j++;
        }
        String res2 = "";
        for(int k = j;k<arr2.length;k++){
            res2 = res2+arr2[k];
        }
        return res2;
    }
}
