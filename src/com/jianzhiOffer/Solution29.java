package com.jianzhiOffer;

/*最小的k个数
* 输入n个整数，找出其中最小的K个数。
* 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution29 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        int len = input.length;
        if(k==0 || len < k){
            return list;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new maxHeapComparator());
        for(int i = 0; i<len; i++){
            if(i<k){
                maxHeap.add(input[i]);
            }else if(maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.add(input[i]);
            }
        }

        while (maxHeap.size()!=0){
            list.add(maxHeap.poll());
        }


        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
//        Collections.reverse(list);
        return list;
    }

    public static class maxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
//            return o2.compareTo(o1);
            return o2-o1;
        }
    }

    public static void main(String[] args) {
//        int[] input = {};
        int[] input = {3,6,8,1,0,9,55};
        ArrayList<Integer> list = GetLeastNumbers_Solution(input,3);
        for(int a :list){
            System.out.println(a);
        }
    }






}
