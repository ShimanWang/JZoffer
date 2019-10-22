package com.examination.DiDi;

//输入第一行仅包含一个正整数n，表示原有魔法阵阵基的数量。(3<=n<=20000)
//输入第二行包含n个整数，第i个整数表示第i个阵基的威力v_i。(-10000<=v_i<=10000)

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = cin.nextInt();
//        }
//
//        solution(n, arr);
        int[] arr= {1,5,2,-3,3,-3};
        solution(6, arr);

    }

    public static void solution(int n, int[] arr) {
        int max = 0;
        int tempMax = 0;
        int interval;
        for (interval = 0; interval <= n / 3; interval++) {
            for (int i = 0; i+(interval+1)*2 < arr.length; i = i+(interval+1)*2) {
                tempMax =tempMax+ arr[i]+arr[i+interval+1];
            }
            if(tempMax>max){
                max = tempMax;
            }
        }


//        for (int i = 0; i < n; i++) {
//            max = max + arr[i];
//        }

        System.out.println(max);
    }
}
