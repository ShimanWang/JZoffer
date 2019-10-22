package com.jianzhiOld;

import java.util.ArrayList;
import java.util.Arrays;

//骰子的点数
public class Solution68 {
    //1.递归解法
    public static ArrayList<Integer> numberOfDice(int n) {
        if (n < 1) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        //list里面添加的是从投掷n次，sum=n~sum=6n的可能投掷次数【题意要求】
        for (int sum = n; sum <= 6 * n; sum++) {
            list.add(process(n, sum));
        }
        return list;
    }

    //ACWing要求返回值是一个int[]
//    public static int[] numberOfDice(int n) {
//        if (n < 1) {
//            return null;
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        //list里面添加的是从投掷n次，sum=n~sum=6n的可能投掷次数【题意要求】
//        for (int sum = n; sum <= 6 * n; sum++) {
//            list.add(process(n,sum));
//        }
//        int[] res = new int[list.size()];
//        for(int i=0;i<list.size();i++){
//            res[i] = list.get(i);
//        }
//        return res;
//    }


    //投掷n次，投掷的总和是sum的有多少种投法
    public static int process(int n, int sum) {
        if (sum < 0 || (n == 0 && sum != 0)) {
            return 0;
        }
        if (n == 0 && sum == 0) {
            return 1;
        }
        int res = 0;

        for (int i = 1; i <= 6; i++) {
            res = res + process(n - 1, sum - i);
        }
        return res;
    }


    //动态规划解法
    public static ArrayList<Integer> numberOfDice2(int n) {
    //public static int[] numberOfDice2(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        //1.状态f[i][j]前i次总和为j的方案数
        int[][] f = new int[n+1][(6 * n)+1];
        f[1][1] = 1;
        f[1][2] = 1;
        f[1][3] = 1;
        f[1][4] = 1;
        f[1][5] = 1;
        f[1][6] = 1;
        //先循环次数
        for (int i = 2; i <= n; i++) {
            //再循环总和是多少
            for (int j = i; j <= 6 * i; j++) {
                //枚举最后一次的点数是多少
                for (int k = 1; (k <= j && k<=6); k++) {//情况
                    //如何计算：按照最后一次的情况，划分成6个集合，最后一次投1~6点，扔每个点都对应一个方案
                    //前两行循环的i,j最后一行循环的是情况  //k一定要<=j
                    //f[i][j] 这六种情况，每种情况的方案数的和
                    f[i][j] = f[i][j]+f[i - 1][j - k];
                }
                //System.out.println("f["+i+"]["+j+"]="+f[i][j]);
            }
        }

        //答案就是最后一层
        for (int r = n; r <= 6*n; r++) {
            list.add(f[n][r]);

        }
        return list;


//        //答案就是最后一层
//        for (int r = n; r <= 6*n; r++) {
//            list.add(f[n][r]);
//        }
//        int[] res = new int[list.size()];
////        int index = 0;
//        for(int index = 0;index<list.size();index++){
//            System.out.println(list.get(index));
//            res[index] = list.get(index);
//
//            //res[index] = list.get(index);
//        }
//        return res;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = numberOfDice(2);
        for (int a : list1) {
            System.out.print(a + " ");
        }

        System.out.println();
        ArrayList<Integer> list2 = numberOfDice2(2);
        //int[] list2 = numberOfDice2(2);
//
        //System.out.println(Arrays.toString(list2));

    }
}
