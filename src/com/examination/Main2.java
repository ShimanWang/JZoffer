package com.examination;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        n = cin.nextInt();

        int[] students = new int[n];

        for(int i = 0;i<n;i++){
            students[i] = cin.nextInt();
        }
        int m ;
        m = cin.nextInt();
        int[] querys = new int[m];

        for(int i = 0;i<m;i++){
            querys[i] = cin.nextInt();
        }
        solution(students,querys);

    }

    public static void solution(int[] students,int[]querys){
        for(int i:querys){
            int score = students[i-1];
            int count = 0;
            for(int j:students){
                if(j<=score){
                    count++;
                }
            }
            double k = (count -1) * 100 / (double)students.length;
            BigDecimal big = new BigDecimal(k);
            double l = big.setScale(6,BigDecimal.ROUND_HALF_UP).doubleValue();
            DecimalFormat df = new DecimalFormat("0.000000");
            System.out.println(df.format(l));
        }
    }

}
