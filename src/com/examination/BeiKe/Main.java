package com.examination.BeiKe;
//琪琪有n个数字，琪琪想知道有多少数字恰好可以用剩下的n-1个数中的两个数和表示
//0<=n<=100
//0<=数字<=10000
//第一行一个数n
//第二行n个数字

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        n = cin.nextInt();
        if (n < 3) {
            System.out.println(0);
        }

        int[] nums = new int[n];

        for(int i = 0;i<n;i++){
            nums[i] = cin.nextInt();
        }

        //int n = 5;
        //int[] nums = {0, 4, 3, 5, 7,9};

        System.out.println(solution(nums));
    }


    public static int solution(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 2; i < arr.length; i++) {
            int target = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
//                    if(arr[j]<target/2){
//                        continue;
//                    }
//                    if(arr[k]>target/2){
//                        continue;
//                    }
                    if (arr[j] + arr[k] == target) {
                        count++;
                    }

                }
            }
        }

        return count;
    }
}
