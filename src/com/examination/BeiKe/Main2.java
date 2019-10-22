package com.examination.BeiKe;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        n = cin.nextInt();

        //2<n<=100
        if(n<=2 || n>100){
            System.out.println(" ");
            return;
        }

        long temp[] = new long[n];

        for (int i = 0; i < n; i++) {
            long a;
            a = cin.nextLong();
            temp[i] = a;
        }

        solution(temp);
    }

    public static void solution(long[] temp) {
        int index1 = 0;
        int index2 = 0;
        long abs = Math.abs(temp[1] - temp[0]);
        boolean change = false;

        if (abs == 0 || temp.length == 2) {
            System.out.println(temp[1] + " " + temp[0]);
            return;
        }

        for (int i = 1; i < temp.length - 1; i++) {
            long flag = Math.abs(temp[i] - temp[i + 1]);
            if (flag == 0) {
                System.out.println(temp[i] + " " + temp[i + 1]);
                return;
            }

            if(flag<abs){
                change = true;
                index1 = i;
                index2 = i+1;
                abs = flag;
            }
        }

        if(change){
            System.out.println(temp[index1] + " " + temp[index2]);
        }else {
            System.out.println(temp[0] + " " + temp[1]);
        }
    }


    public static void solution1(int[] arr){
        //构造数组B=（b1,b2,...,bn-1）
        int[] arr_b = new int[arr.length-1];
        for(int i = 0;i<arr.length-1;i++){
            arr_b[i] = arr[i] - arr[i+1];
            if(arr_b[i] == 0){
                System.out.println(arr[i] + " " + arr[i + 1]);
                return;
            }
        }

        //数组B最小绝对值子段和
        int[] arr_c = new int[arr_b.length];
        int min = Integer.MAX_VALUE;
        int flag = 0;
        for(int i = 0;i<arr_c.length;i++){
            for(int j = 0;j<=i;j++){
                arr_c[j]+=arr_b[i];
                if(Math.abs(min)>Math.abs(arr_c[j])){
                    min = Math.abs(arr_c[j]);
                    flag = j;
                }
            }
        }
        System.out.println(arr[flag] + " " + arr[flag + 1]);
    }
}
