package com.jianzhiOffer;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
 * 1.判断当前最大值是否过期
 * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
 */
public class Solution64 {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        //begin是用于保存当前窗口的第一个值在原始数组中的【下标】
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty())
                q.add(i);
                //获取队列第一个元素.
            else if (begin > q.peekFirst())
                q.pollFirst();

            //pollLast获取并移除队列第一个元素
            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if (begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }


    //优先级队列实现
    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int count = 0;
        for (int i = 0; i < num.length; i++) {
        }

        return list;
    }

    //双端队列实现
    public static ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        //异常情况(窗口大小必须大于等于1)
        if(size<1 || num.length<size){
            return list;
        }
        //双端队列
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i =0;i<num.length;i++){

            if(queue.isEmpty()){
                //队列中放的是数字在数组中的下标
                queue.add(i);
            //判断队首元素是不是已经出了滑动窗口
            }else if(i-queue.getFirst()>=size){
                queue.pollFirst();
            }
            //新增加的值从队尾开始比较，把所有比他小的值丢掉(如果队列中有比新增加的值小的数字，那这个小的数字永无出头之日)
            //队列中只有一个值的时候，队首元素出队后，队列就空了，所以加一个判断条件:!queue.isEmpty()
            while (!queue.isEmpty()&&num[queue.getLast()]<=num[i]){
                queue.pollLast();
            }
            queue.add(i);
            //当判断的数字数量还没到窗口大小的时候
            if(i>=size-1){
                list.add(num[queue.getFirst()]);//始终保持双端队列的对头是窗口中最大的元素
            }
        }
        return list;
    }



    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        //ArrayList<Integer> listStand = maxInWindows(arr, 3);
        ArrayList<Integer> list1 = maxInWindows1(arr, 3);
//        for(int a :listStand){
//            System.out.print(a+" ");
//        }
        System.out.println();
        for(int a :list1){
            System.out.print(a+" ");
        }
    }
}
