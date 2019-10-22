package com.NbasicClass.Class08;

import java.util.PriorityQueue;

public class LessMoney {
    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i =0;i<arr.length; i++){
            queue.add(arr[i]);
        }
        int cost = 0;
        int newNode;
        while(queue.size() > 1){
            newNode = queue.poll()+queue.poll();
            cost = cost+newNode;
            queue.add(newNode);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30};
        System.out.println(lessMoney(arr));
    }
}
