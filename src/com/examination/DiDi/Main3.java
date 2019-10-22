package com.examination.DiDi;
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
            max +=arr[i];
        }

        if(n%2 !=0){
            System.out.println(max);
            return;
        }

        int sum = n;
        int sitesun2 = max;
        while (sum%2 == 0){
            sum = sum/2;
            int step = n/sum;
            int sitesun1 = Integer.MIN_VALUE;
            for(int i=0;i<step;i++){
                int sitesum = 0;
                for(int j=i;j<n;j=j+step){
                    sitesum = sitesum+arr[j];
                }
                sitesun1=Math.max(sitesun1,sitesum);
            }
            sitesun2 = Math.max(sitesun2,sitesun1);
        }
        System.out.println(sitesun2);
    }
}
