package com.examination.JD;

import java.util.ArrayList;
import java.util.Scanner;

//第一行包含一个整数N，1≤N≤105。
//第二行包含N个空格隔开的整数H1到HN，1≤Hi≤109。
public class Main2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        long[][] sort = new long[n][2];
        for(int i =0;i<n;i++){
            sort[i][0] = i;
            int H = cin.nextInt();
            sort[i][1] = H;
        }

        for(int i = 0;i<n-1;i++){
            if(sort[i][1]>sort[i+1][1]){
                long[] temp = sort[i];
                sort[i]= sort[i+1];
                sort[i+1] = temp;
            }
        }
        System.out.println(solution(sort));

//        ArrayList<Integer> arrayList = new ArrayList<>();
//        int num;
//        for(int i = 0;i<n;i++){
//            num = cin.nextInt();
//            arrayList.add(num);
//        }
        //solution();
    }

    public static int solution(long[][] arr) {

        int count = 0;
        for(int i = 1;i<arr.length;i++){
            if(Math.abs(arr[i][0] - arr[i-1][0])>1){
                count++;
            }
        }
        return count+1;
    }
}
