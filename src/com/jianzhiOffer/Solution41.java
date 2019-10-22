package com.jianzhiOffer;

import java.util.ArrayList;

public class Solution41 {

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        //设置两个指针
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int low = 1;
        int high = 2;
        while (low < high) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int curSum = (low + high) * (high - low + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                lists.add(list);
                low++;
                high++;
            //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if (curSum < sum) {
                high++;
            }else if(curSum>sum){
            //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                low++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = FindContinuousSequence(15);
        for (ArrayList<Integer> list : lists) {
            for (int a : list) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
