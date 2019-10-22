package com.examination;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t;
        t = cin.nextInt();
        ArrayList<int[]> list =  new ArrayList<>();

        for(int i=0;i<t;i++){
            int n ;
            n = cin.nextInt();
            int[] as = new int[n];
            for(int j = 0;j<n;j++){
                as[j] = cin.nextInt();
            }
            list.add(as);
        }
        solution(list);
    }

    public static void solution(ArrayList<int[]> list){
        boolean flag = true;
        for(int[] is :list){
            for(int i =0;i<is.length;i++){
                if(i==0){
                    if(is[i]>(is[i+1]+is[is.length-1])){
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                }else if(i==is.length-1) {
                    if(is[i]>(is[i-1]+is[0])){
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                }else {
                    if(is[i]>(is[i-1]+is[i+1])){
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                System.out.println("YES");
            }
        }
    }
}
