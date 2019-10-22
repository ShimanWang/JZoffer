package com.examination.Tencent;

import java.util.Scanner;
import java.util.Stack;

public class Main4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[]w = new int[n];
        for(int i =0;i<n;i++){
            w[i] = cin.nextInt();
        }
        //long res = solution(w);
        System.out.println(solution(w));
    }


    public static long solution(int[] arr){
        Stack<Integer> stack = new Stack<>();
        long max = 0xcfcfcfcf;
        int len = arr.length;
        for(int i = 0;i<len;i++){
            if(stack.empty() || arr[i]>=arr[stack.peek()]){    //规则1
                stack.push(i);
            }else {
                while (!stack.empty()&&arr[stack.peek()]>=arr[i]){    //规则2
                    int top = stack.peek();
                    stack.pop();
                    long temp = stack.empty() ? process(arr,0,i-1):process(arr,stack.peek()+1,i-1);
                    long current = arr[top]*temp;
                    max = Math.max(current,max);
                }
                stack.push(i);
            }
        }
        while (!stack.empty()){
            int top = stack.peek();
            stack.pop();
            long temp = stack.empty() ? process(arr,0,len-1):process(arr,stack.peek()+1,len-1);
            long currentSum = arr[top]*temp;
            max = Math.max(currentSum,max);
        }
        return max;
    }

    static long process(int[] num, int i,int j){
        long sum = 0;
        for(int k =i; k<=j;k++){
            sum += num[k];
        }
        return sum;
    }
}
