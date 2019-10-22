package com.jianzhiOffer;

import java.util.ArrayList;

//丑数
public class Solution33 {
    public static int GetUglyNumber_Solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0;//下标
        int i3 = 0;
        int i5 = 0;

        while (list.size() < n){
            int m2 = list.get(i2)*2;
            int m3 = list.get(i3)*3;
            int m5 = list.get(i5)*5;

            int min = Math.min(Math.min(m2,m3),m5);
            list.add(min);
            if(min == m2) i2++;
            if(min == m3) i3++;
            if(min == m5) i5++;
        }
        return list.get(n-1);
    }

    public static void main(String[] args) {
        int res = GetUglyNumber_Solution(3);
        System.out.println(res);
    }
}
