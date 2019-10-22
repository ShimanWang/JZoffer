package com.jianzhiOffer;

import java.util.ArrayList;

//圈中最后剩下的数字
//0, 1, …, n-1这n个数字(n>0)排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字
//求出这个圆圈里剩下的最后一个数字。
public class Solution46 {
    public static int LastRemaining_Solution(int n, int m) {
        if(n==0){return -1;}
        ArrayList<Integer> list = new ArrayList<>();
        //把0~n-1个编号放入list
        for(int i=0;i<n;i++){
            list.add(i);
        }
        //System.out.println(list.size());
        //只要list中的数>1就证明剩下的不是最后一个数字
        while (list.size()>1){
            int j = 0;
            while(j<m-1){
                list.add(list.remove(0));
                j++;
            }
            list.remove(0);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int res = LastRemaining_Solution(5,3);
        System.out.println(res);
    }
}
